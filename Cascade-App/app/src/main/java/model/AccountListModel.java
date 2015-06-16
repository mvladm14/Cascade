package model;

/**
 * Created by Vlad on 4/27/2015.
 */
public class AccountListModel {

    private Account account;
    private String image = "";

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {

        this.account = account;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }
}
