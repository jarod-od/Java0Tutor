package by.java_intro.programming_with_classes_4.aggr_comp5;

import java.util.Scanner;
import java.io.IOException;

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

        boolean isVoucherChosen = false;
        int chosenVoucherId = -1;

        while (!isVoucherChosen) {
            // main loop start

            int res = 0;
            while(true) {
                res = getCode("Choose voucher by parameters (1) or select from list (2)?");
                if (res == 1 || res == 2) {
                    break;
                }
            }
            

            if (res == 1) {
                // choose by parameters
                boolean isParametersChosen = false;

                VoucherType typeParameter = null;
                Feed feedParameter = null;
                Transport transportParameter = null;

                while(!isParametersChosen) {
                    // choose by parameters loop start
                    
                    while(true) {
                        res = getCode("Choose parameter type (1) or feed (2) or transport (3) or start finding by choosen parameters (0) :");
                        if (res == 1 || res == 2 || res == 3 || res == 0) {
                            break;
                        }
                    }

                    String value = null;
                    while (true) {
                        System.out.println("Choose parameter value:");
                        //todo
                        try {
                            Scanner s = new Scanner(System.in);
                            value = s.nextLine();
                            break;
                        } catch(IOException e) {
                            System.out.println("Input error");
                        }
                    }

                    switch(res) {
                        case 0:
                            // stop
                            isParametersChosen = true;
                            break;
                        case 1:
                            // type
                            typeParameter = true;
                            break;
                        case 2:
                            // feed
                            feedParameter = true;
                            break;
                        case 3:
                            // transport
                            transportParameter = true;
                            break;
                    }

                    // choose by parameters loop end
                }

            } else if (res == 2) {
                
                while(!isVoucherChosen) {
                    // select from list loop start

                    System.out.println("Vouchers list: ");
                    for(Voucher voucher : vouchers) {
                        System.out.println(voucher.toString());
                    }

                    while(true) {
                        res = getCode("Choose voucher (1) or sort list (2)?");
                        if (res == 1 || res == 2) {
                            break;
                        }
                    }

                    if (res == 1) {
                        while(true) {
                            res = getCode("Input chosen voucher id :");
                            if (res >= 0 && res < vouchers.length) {
                                break;
                            }
                        }

                        chosenVoucherId = res;
                        isVoucherChosen = true;
                    } else if (res == 2) {
                        // sort
                        while(true) {
                            res = getCode("Sort vouchers by type (1) or feed (2) or transport (3)?");
                            if (res == 1 || res == 2 || res == 3) {
                                break;
                            }
                        }
                        
                        vouchers = sortVouchers(vouchers, res);
                    }

                    // select from list loop end
                }
            }
            // main loop end
        }
        
        //find voucher by id


    }

    private Voucher[] sortVouchers(Voucher[] vouchers, int sortParameter) {
        switch (sortParameter) {
            case 1:
                // type
                break;
            case 2:
                // feed
                break;
            case 3:
                // transport
                break;
        }
        return sortedVouchers;
    }

    private static int getCode(String question) {
        int res = 0;
        while (true) {
            System.out.println(question);
            try {
                Scanner s = new Scanner(System.in);
                res = s.nextInt();
                if (res < 0) {
                    throw new IOException();
                }
                break;
            } catch(IOException e) {
                System.out.println("Input error");
            }
        }
        return res;
    }
}