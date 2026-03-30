//package banking_app;
//
//import java.util.Scanner;
//
//public class Bank {
//
//	public static void main(String[] args) throws Exception {
//		int accountNumber = 12345;
//		int password = 123;
//		AtmOperationInterf a = new AtmOperation();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Welcome to the ATM Machine");
//		//Accepting account details
//		System.out.print("Enter Account Number: ");
//		int an = sc.nextInt();
//		System.out.print("Enter Password: ");
//		int pwd = sc.nextInt();
//		//validating account details
//		if(an == accountNumber && pwd == password) {
//			while(true) {
//				System.out.println();
//				System.out.println("1.Deposit\n2.Withdraw\n3.Check Balance\n4.Mini Statement\n5.Exit");
//				System.out.println("Enter your choice = ");
//				int choice = sc.nextInt();
//				if(choice == 1) {
//					System.out.println("Enter amount to deposited: ");
//					int depositAmount = sc.nextInt();
//					if(depositAmount > 0) {
//						a.deposit(depositAmount);
//					}
//					else {
//						System.out.println("Invalid amount");
//					}
//				}
//				else if(choice == 2) {
//					System.out.println("Enter amount to be withdrawn:");
//					int withdrawAmount = sc.nextInt();
//					if (withdrawAmount > 0) {
//						a.withdraw(withdrawAmount);
//					} else {
//						System.out.println("Invalid amount");
//					}
//				}
//				else if(choice == 3) {
//					a.viewBalance();
//				}
//				else if(choice == 4) {
//					a.viewMiniStatement();
//				}
//				else if(choice == 5) {
//					System.out.println("Session terminating...");
//					System.exit(0);
//				}
//				else {
//					System.out.println("Invalid choice..Try again");
//				}
//			}
//		}
//		else {
//			System.out.println("Invalid account number or password");
//			System.exit(0);
//		}
//		sc.close();
//	}
//}
//
//


package banking_app;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) throws Exception {
        int accountNumber = 12345;
        int password = 123;

        AtmOperationInterf a = new AtmOperation();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the ATM Machine");

        // ✅ Login attempts added
        int attempts = 3;
        boolean isAuthenticated = false;

        while (attempts > 0) {
            System.out.print("Enter Account Number: ");
            int an = sc.nextInt();

            System.out.print("Enter Password: ");
            int pwd = sc.nextInt();

            if (an == accountNumber && pwd == password) {
                isAuthenticated = true;
                break;
            } else {
                attempts--;
                System.out.println("Invalid account number or password");
                System.out.println("Attempts left: " + attempts);
            }
        }

        if (!isAuthenticated) {
            System.out.println("Too many failed attempts. Account blocked.");
            sc.close();
            System.exit(0);
        }

        // ✅ Main menu (same logic, just switch-case)
        while (true) {
            System.out.println();
            Thread.sleep(3000);

            System.out.println("1.Deposit\n2.Withdraw\n3.Check Balance\n4.Mini Statement\n5.Exit");
            System.out.print("Enter your choice = ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposited: ");
                    int depositAmount = sc.nextInt();
                    if (depositAmount > 0) {
                        a.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to be withdrawn: ");
                    int withdrawAmount = sc.nextInt();
                    if (withdrawAmount > 0) {
                        a.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;

                case 3:
                    a.viewBalance();
                    break;

                case 4:
                    a.viewMiniStatement();
                    break;

                case 5:
                    System.out.println("Session terminating...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.. Please try again.");
            }
        }
    }
}
