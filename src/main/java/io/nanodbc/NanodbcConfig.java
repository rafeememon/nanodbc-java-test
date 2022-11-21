package io.nanodbc;

import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(
        value = {
                @Platform(
                        include = {"nanodbc.h"},
                        link = {"nanodbc"})}
// , target = "io.nanodbc.NanodbcNative"
)
public class NanodbcConfig implements InfoMapper {

    @Override
    public void map(InfoMap infoMap) {
        infoMap.put(new Info("std::vector<uint8_t>").pointerTypes("UInt8Vector").define())
                .put(new Info("std::list<std::u32string>").pointerTypes("U32StringList").define())
                .put(new Info("std::list<nanodbc::datasource>").pointerTypes("DatasourceList").define())
                .put(new Info("std::list<nanodbc::driver>").pointerTypes("DriverList").define())
                .put(new Info("std::list<nanodbc::driver::attribute>").pointerTypes("DriverAttributeList").define())
                .put(new Info("nanodbc::driver::attribute").pointerTypes("driver.Attribute"))
                .put(new Info("std::runtime_error").cast().pointerTypes("Pointer"))
                // https://github.com/bytedeco/javacpp-presets/issues/528#issuecomment-369136919
                .put(new Info("NANODBC_DEPRECATED").cppText("#define NANODBC_DEPRECATED"));
        // .put(new Info("nanodbc.h").linePatterns("\\s*#define NANODBC_DEPRECATED .*").skip());
    }

}
