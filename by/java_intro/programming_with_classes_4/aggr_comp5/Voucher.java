package by.java_intro.programming_with_classes_4.aggr_comp5;

public class Voucher {
    private int id;
    private VoucherType type;
    private Transport transport;
    private Feed feed;
    private int duration;
    public Voucher(int id, VoucherType type, Transport transport, Feed feed, int duration) {
        this.id = id;
        this.type = type;
        this.transport = transport;
        this.feed = feed;
        this.duration = duration;
    }
}