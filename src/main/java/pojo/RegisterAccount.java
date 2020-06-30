package pojo;

public class RegisterAccount {

    private String firstName;
    private String lastName;
    private String telephone;
    private String password;
    private String passwordConfirm;

    private boolean shouldLogin; //bandera que indica si el usuario deberia o no loguearse

    // si solo se usa para parsear de json a pojo no requiere constructor
    public RegisterAccount(String _firstName, String _lastName,  String _telephone, String _password, String _passwordConfirm, boolean _shouldSubscribe){
        this.setFirstName(_firstName);
        this.setLastName(_lastName);
        this.setTelephone(_telephone);
        this.setPassword(_password);
        this.setPasswordConfirm(_passwordConfirm);
        this.setShouldSubscribe(_shouldSubscribe);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public boolean isShouldSubscribe() {
        return shouldLogin;
    }

    public void setShouldSubscribe(boolean shouldSubscribe) {
        this.shouldLogin = shouldSubscribe;
    }

    @Override
    public String toString(){
        return (String.format("Email: %s and password: %s","email",password));
    }
}
