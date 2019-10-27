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

    public int getId() {
        return this.id;
    }

    public VoucherType getType() {
        return this.type;
    }

    public Transport getTransport() {
        return this.transport;
    }

    public Feed getFeed() {
        return this.feed;
    }

    public int getDuration() {
        return this.duration;
    }

    @Override
    public String toString() {
        return "{Voucher id: " + id 
            + "; type: " + type.getType() 
            + "; transport: " + transport.getType() 
            + "; feed: " + feed.getType() 
            + "; duration: " + duration + "}";
    }
}