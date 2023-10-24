package info.gratour.jt808common;

public class JT808Consts {

    public static class ProtocolVersions {
        public static final byte PROTO_VER__REV2013 = 0;
        public static final byte PROTO_VER__REV2019 = 1;

        public static boolean isValidProtoVer(int ver) {
            return ver == PROTO_VER__REV2013 || ver == PROTO_VER__REV2019;
        }
    }
}
