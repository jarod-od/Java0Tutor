package by.java_intro.programming_with_classes_4.class8;
/**
 *  8. Создать класс  Customer, спецификация которого приведена ниже. 
 * Определить конструкторы,  set- и  get- методы  и метод  toString(). 
 * Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами  и методами. 
 * Задать критерии выбора данных и вывести эти данные на консоль.     
 * Класс  Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.    
 * Найти и вывести:   
 *  a) список покупателей в алфавитном порядке;    
 *  b) список покупателей, у которых номер кредитной карточки находится в заданном интервале 
 */

public class Customer {
    private int id;
    private String subName;
    private String firstName;
    private String patronymic;
    private String address;
    private long cardNumber;
    private long bankAccountNumber;

    public Customer(int id, String subName, String firstName, String patronymic, String address, long cardNumber, long bankAccountNumber) {
        this.id = id;
        this.subName = subName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.cardNumber = cardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer() {
        this(0, "", "", "", "", 0, 0);
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubName() {
        return this.subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getBankAccountNumber() {
        return this.bankAccountNumber;
    }

    public void setBankAccountNumber(long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", subName='" + getSubName() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", patronymic='" + getPatronymic() + "'" +
            ", address='" + getAddress() + "'" +
            ", cardNumber='" + getCardNumber() + "'" +
            ", bankAccountNumber='" + getBankAccountNumber() + "'" +
            "}";
    }
}