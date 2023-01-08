package io.nanodbc;

import org.bytedeco.javacpp.CharPointer;

import io.nanodbc.NanodbcNative.Connection;
import io.nanodbc.NanodbcNative.Result;
import io.nanodbc.NanodbcNative.Statement;

public class RafeeTest {

    public static void main(String[] args) {
        Connection c = new Connection();
        c.connect(str("DSN=EquipMgrX5E_64"));
        // SELECT UnitID, UnitDesc FROM UnitTitles WHERE UnitDesc = 'µA'
        Statement s = new Statement(c, str("SELECT UnitID, UnitDesc FROM UnitTitles WHERE UnitID = 5"));
        Result r = s.execute();
        while (r.next()) {
            int id = r.getInt(str("UnitID"));
            // String desc = r.getString(str("UnitDesc"));
            CharPointer desc = r.getString(str("UnitDesc"));
            // System.out.println(id + " " + desc.getString());
            System.out.println(id + " " + desc.getString());
        }
    }

    private static CharPointer str(String string) {
        return new CharPointer(string);
    }

}
