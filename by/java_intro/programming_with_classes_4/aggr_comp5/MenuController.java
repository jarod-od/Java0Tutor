package by.java_intro.programming_with_classes_4.aggr_comp5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * MenuController
 */
public class MenuController {

    private Voucher[] vouchers;
    private VoucherType[] type;
    private Transport[] transport;
    private Feed[] feed;
    private boolean isVoucherChoosen = false;
    private int choosenVoucherId = -1;

    public MenuController(Voucher[] vouchers, VoucherType[] type, Transport[] transport, Feed[] feed) {
        this.vouchers = vouchers;
        this.type = type;
        this.transport = transport;
        this.feed = feed;
    }

    public void runMainMenu() {
        boolean mainMenuRunning = true;
        while(mainMenuRunning) {
            System.out.println("Input action: ");
            System.out.println("1 - choose voucher by parameters");
            System.out.println("2 - select voucher from list");
            System.out.println("0 - exit");
            int code = getCode(new int[]{0, 1, 2});
            switch (code) {
                case 0:
                    mainMenuRunning = false;
                    break;
                case 1:
                    runChooseVoucherByParametersMenu();
                    break;
                case 2:
                    runSelectVoucherFromListMenu();
                    break;
                default:
                    break;
            }
            
            if (isVoucherChoosen) {
                isVoucherChoosen = false;
                System.out.println("Choosen voucher: ");
                for (Voucher voucher : vouchers) {
                    if (voucher.getId() == choosenVoucherId) {
                        System.out.println(voucher);
                        break;
                    }
                }
                
            }
        }
    }

    private void runChooseVoucherByParametersMenu() {

        VoucherType typeParameter = chooseType();
        Transport transportParameter = chooseTransport();
        Feed feedParameter = chooseFeed();

        List<Voucher> paramsVouchers = new ArrayList<>();

        if (typeParameter == null) {
            for (Voucher voucher : vouchers) {
                paramsVouchers.add(voucher);
            }
        } else {
            for (Voucher voucher : vouchers) {
                if (voucher.getType().equals(typeParameter)) {
                    paramsVouchers.add(voucher);
                }
            }
        }
        
        
        if (transportParameter != null) {
            List<Voucher> tempVouchers = new ArrayList<>();
            for (Voucher voucher : paramsVouchers) {
                if (voucher.getTransport().equals(transportParameter)) {
                    tempVouchers.add(voucher);
                }
            }
            paramsVouchers = tempVouchers;
        }

        if (feedParameter != null) {
            List<Voucher> tempVouchers = new ArrayList<>();
            for (Voucher voucher : paramsVouchers) {
                if (voucher.getFeed().equals(feedParameter)) {
                    tempVouchers.add(voucher);
                }
            }
            paramsVouchers = tempVouchers;
        }

        if (paramsVouchers.size() == 0) {
            System.out.println("No such vouchers found");
        } else {
            viewVouchers(paramsVouchers);
            runChooseByIdMenu(paramsVouchers);
        }
    }

    private VoucherType chooseType() {
        int[] allowedCodes = new int[type.length + 1];
        for (int i = 0; i <= type.length; i++) {
            allowedCodes[i] = i;
        }

        System.out.println("Choose type: ");
        System.out.println(0 + " - any");
        for (int i = 1; i <= type.length; i++) {
            System.out.println(i + " - " + type[i - 1].getType());
        } 
        int code = getCode(allowedCodes);

        if (code == 0) {
            return null;
        } else {
            return type[code - 1];
        }
    }

    private Transport chooseTransport() {
        int[] allowedCodes = new int[transport.length + 1];
        for (int i = 0; i <= transport.length; i++) {
            allowedCodes[i] = i;
        }

        System.out.println("Choose transport: ");
        System.out.println(0 + " - any");
        for (int i = 1; i <= transport.length; i++) {
            System.out.println(i + " - " + transport[i - 1].getType());
        } 
        int code = getCode(allowedCodes);
        if (code == 0) {
            return null;
        } else {
            return transport[code - 1];
        }
    }

    private Feed chooseFeed() {
        int[] allowedCodes = new int[feed.length + 1];
        for (int i = 0; i <= feed.length; i++) {
            allowedCodes[i] = i;
        }

        System.out.println("Choose feed: ");
        System.out.println(0 + " - any");
        for (int i = 1; i <= feed.length; i++) {
            System.out.println(i + " - " + feed[i - 1].getType());
        } 
        int code = getCode(allowedCodes);
        if (code == 0) {
            return null;
        } else {
            return feed[code - 1];
        }
    }

    private void runSelectVoucherFromListMenu() {

        viewVouchers(this.vouchers);

        System.out.println("Input action: ");
        System.out.println("Choose voucher by id - 1");
        System.out.println("Choose voucher from sorted list - 2");
        int code = getCode(new int[]{1, 2});
        
        switch (code) {
            case 1:
                runChooseByIdMenu(this.vouchers);
                break;
            case 2:
                runChooseFromSortedList();
                break;
            default:
                break;
        }
    }

    private void runChooseByIdMenu(Voucher[] givenVouchers) {
        System.out.println("Input chosen voucher id :");
        int[] allowedCodes = new int[givenVouchers.length];
        for (int i = 0; i < givenVouchers.length; i++) {
            allowedCodes[i] = givenVouchers[i].getId();
        }
        int code = getCode(allowedCodes);
        isVoucherChoosen = true;
        choosenVoucherId = code;
    }

    private void runChooseByIdMenu(List<Voucher> givenVouchers) {
        System.out.println("Input chosen voucher id :");
        int[] allowedCodes = new int[givenVouchers.size()];
        for (int i = 0; i < givenVouchers.size(); i++) {
            allowedCodes[i] = givenVouchers.get(i).getId();
        }
        int code = getCode(allowedCodes);
        isVoucherChoosen = true;
        choosenVoucherId = code;
    }

    private void runChooseFromSortedList() {

        System.out.println("Input parameter for sort: ");
        System.out.println("1 - type");
        System.out.println("2 - transport");
        System.out.println("3 - feed");
        int code = getCode(new int[]{1, 2, 3});

        Voucher[] sortedVouchers = sortVouchers(code);
        
        viewVouchers(sortedVouchers);

        runChooseByIdMenu(sortedVouchers);
    }

    private void viewVouchers(Voucher[] givenVouchers) {
        System.out.println("Vouchers list: ");
        for(Voucher voucher : givenVouchers) {
            System.out.println(voucher.toString());
        }
    }

    private void viewVouchers(List<Voucher> givenVouchers) {
        System.out.println("Vouchers list: ");
        for(Voucher voucher : givenVouchers) {
            System.out.println(voucher.toString());
        }
    }

    @SuppressWarnings("resource")
    private int getCode(int[] allowedCodes) {
        int code = -1;
        while(true) {
            if (allowedCodes != null) {
                System.out.println("Input code (allowed: " + getStringFromIntArray(allowedCodes) + "):");
            } else {
                System.out.println("Input code:");
            }
            
            try {
                Scanner s = new Scanner(System.in);
                code = s.nextInt();
                if (allowedCodes != null) {
                    boolean isContains = false;
                    for (int a : allowedCodes) {
                        if (a == code) {
                            isContains = true;
                            break;
                        }
                    }
                    if (isContains) {
                        break;
                    }
                } else {
                    break;
                }
            } catch(Exception e) {
                //e.printStackTrace();
            }
            System.out.println("Invalid input");
        }
        return code;
    }

    private String getStringFromIntArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private Voucher[] sortVouchers(int sortParameter) {
        Voucher[] sortedVouchers = null;
        switch (sortParameter) {
            case 1:
                sortedVouchers = sortByType();
                break;
            case 2:
                sortedVouchers = sortByTransport();
                break;
            case 3:
                sortedVouchers = sortByFeed();
                break;
        }
        return sortedVouchers;
    }

    private Voucher[] sortByType() {
        Voucher[] sortedVouchers = new Voucher[vouchers.length];
        for (int i = 0; i < vouchers.length; i++) {
            sortedVouchers[i] = vouchers[i];
        }
        
        Arrays.sort(sortedVouchers, (v1, v2) -> {
            return v1.getType().getType().compareTo(v2.getType().getType());
        });
        return sortedVouchers;
    }

    private Voucher[] sortByTransport() {
        Voucher[] sortedVouchers = new Voucher[vouchers.length];
        for (int i = 0; i < vouchers.length; i++) {
            sortedVouchers[i] = vouchers[i];
        }
        
        Arrays.sort(sortedVouchers, (v1, v2) -> {
            return v1.getTransport().getType().compareTo(v2.getTransport().getType());
        });
        return sortedVouchers;
    }

    private Voucher[] sortByFeed() {
        Voucher[] sortedVouchers = new Voucher[vouchers.length];
        for (int i = 0; i < vouchers.length; i++) {
            sortedVouchers[i] = vouchers[i];
        }
        
        Arrays.sort(sortedVouchers, (v1, v2) -> {
            return v1.getFeed().getType().compareTo(v2.getFeed().getType());
        });
        return sortedVouchers;
    }
}