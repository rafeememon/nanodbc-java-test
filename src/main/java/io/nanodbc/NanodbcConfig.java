package io.nanodbc;

import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(
        value = {
                @Platform(
                        include = {"nanodbc/nanodbc.h"},
                        link = {"nanodbc", "odbc32"})},
        target = "io.nanodbc.NanodbcNative")
public class NanodbcConfig implements InfoMapper {

    @Override
    public void map(InfoMap infoMap) {
        infoMap
                .put(new Info("!defined(NANODBC_DISABLE_ASYNC)").define(false))
                .put(new Info("NANODBC_DISABLE_ASYNC").define())
                .put(new Info("NANODBC_ENABLE_UNICODE").define())
                .put(new Info("_MSC_VER").define())
                // https://github.com/bytedeco/javacpp/wiki/Mapping-Recipes#ignoring-attributes-and-macros
                .put(new Info("NANODBC_THROW_NO_SOURCE_LOCATION").cppTypes().annotations())
                // https://github.com/bytedeco/javacpp/wiki/Mapping-Recipes#redefining-the-code-of-a-macro
                .put(new Info("NANODBC_DEPRECATED").cppText("#define NANODBC_DEPRECATED"))

                .put(new Info("nanodbc::string").cppTypes("std::wstring").annotations("@StdWString"))

                // Connection

                .put(new Info("nanodbc::connection").pointerTypes("Connection"))

                // Statement

                .put(new Info("nanodbc::statement").pointerTypes("Statement"))

                .put(new Info("nanodbc::statement::bind<short>").javaNames("bindShort"))
                .put(new Info("nanodbc::statement::bind<int>").javaNames("bindInt"))
                .put(new Info("nanodbc::statement::bind<long long>").javaNames("bindLong"))
                .put(new Info("nanodbc::statement::bind<float>").javaNames("bindFloat"))
                .put(new Info("nanodbc::statement::bind<double>").javaNames("bindDouble"))
                .put(new Info("nanodbc::statement::bind<nanodbc::date>").javaNames("bindDate"))
                .put(new Info("nanodbc::statement::bind<nanodbc::time>").javaNames("bindTime"))
                .put(new Info("nanodbc::statement::bind<nanodbc::timestamp>").javaNames("bindTimestamp"))
                .put(new Info("nanodbc::statement::bind<wchar_t>").javaNames("bindString"))

                // Result

                .put(new Info("nanodbc::result").pointerTypes("Result"))
                .put(new Info("nanodbc::result_iterator").pointerTypes("ResultIterator"))

                .put(new Info("nanodbc::result::get<short>").javaNames("getShort"))
                .put(new Info("nanodbc::result::get<int>").javaNames("getInt"))
                .put(new Info("nanodbc::result::get<long long>").javaNames("getLong"))
                .put(new Info("nanodbc::result::get<float>").javaNames("getFloat"))
                .put(new Info("nanodbc::result::get<double>").javaNames("getDouble"))
                .put(new Info("nanodbc::result::get<nanodbc::date>").javaNames("getDate"))
                .put(new Info("nanodbc::result::get<nanodbc::time>").javaNames("getTime"))
                .put(new Info("nanodbc::result::get<nanodbc::timestamp>").javaNames("getTimestamp"))
                .put(new Info("nanodbc::result::get<std::wstring>").javaNames("getString"))

                // Transaction

                .put(new Info("nanodbc::transaction").pointerTypes("Transaction"))

                // Miscellaneous

                .put(new Info("nanodbc::date").pointerTypes("Date"))
                .put(new Info("nanodbc::time").pointerTypes("Time"))
                .put(new Info("nanodbc::timestamp").pointerTypes("Timestamp"))

                .put(new Info("nanodbc::catalog").pointerTypes("Catalog"))
                .put(new Info("nanodbc::datasource").pointerTypes("Datasource"))
                .put(new Info("nanodbc::driver").pointerTypes("Driver"))
                .put(new Info("nanodbc::driver::attribute").pointerTypes("Driver.Attribute"))

                .put(new Info("nanodbc::type_incompatible_error").pointerTypes("TypeIncompatibleError"))
                .put(new Info("nanodbc::null_access_error").pointerTypes("NullAccessError"))
                .put(new Info("nanodbc::index_range_error").pointerTypes("IndexRangeError"))
                .put(new Info("nanodbc::programming_error").pointerTypes("ProgrammingError"))
                .put(new Info("nanodbc::database_error").pointerTypes("DatabaseError"))

                .put(new Info("std::vector<uint8_t>").pointerTypes("UInt8Vector").define())
                .put(new Info("std::list<std::wstring>").pointerTypes("StringList").define())
                .put(new Info("std::list<nanodbc::datasource>").pointerTypes("DatasourceList").define())
                .put(new Info("std::list<nanodbc::driver>").pointerTypes("DriverList").define())
                .put(new Info("std::list<nanodbc::driver::attribute>").pointerTypes("DriverAttributeList").define())
                .put(new Info("std::runtime_error").cast().pointerTypes("Pointer"));
    }

}
