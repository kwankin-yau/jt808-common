package info.gratour.jt808common.codec.decoder;

public enum  DecodeState {

    UNRECOGNIZED,
    RECOGNIZED,
    DECODED;

    public boolean ok() {
        return this != UNRECOGNIZED;
    }
}
