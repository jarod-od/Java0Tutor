package by.java_intro.programming_with_classes_4.aggr_comp5;

/**
 * 5. Туристические путевки. Сформировать набор предложений клиенту по выбору 
 * туристической путевки  различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) 
 * для оптимального выбора. Учитывать  возможность выбора транспорта, питания и числа дней. 
 * Реализовать выбор и сортировку путевок. 
 */

public class VoucherTest {
    public static void main(String[] args) {
        Feed[] feed = new Feed[] {
            new Feed("launch only"), 
            new Feed("all") 
        };

        Transport[] transport = new Transport[] {
            new Transport("airplane"), 
            new Transport("train") 
        };

        VoucherType[] type = new VoucherType[] { 
            new VoucherType("отдых"), 
            new VoucherType("экскурсия"), 
            new VoucherType("лечение"), 
            new VoucherType("шопинг"), 
            new VoucherType("круиз") 
        };

        Voucher[] vouchers = new Voucher[] { 
            new Voucher(1, type[0], transport[1], feed[0], 7), 
            new Voucher(2, type[2], transport[0], feed[1], 14), 
            new Voucher(3, type[4], transport[1], feed[0], 7), 
            new Voucher(4, type[3], transport[0], feed[1], 21), 
            new Voucher(5, type[1], transport[1], feed[0], 7)
        };

        MenuController menuController = new MenuController(vouchers, type, transport, feed);
        menuController.runMainMenu();
    }
}