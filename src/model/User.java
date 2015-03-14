package model;

import main.MainClass;

import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by root on 12.03.15.
 */
public class User {
    private String login;
    private String pass;
    private BigInteger _pass;
    private BigInteger key;
    private BigInteger modules;
    private int count = 0;
    private RSA rsa;
    private static ArrayList<Tradition> list = new ArrayList<Tradition>();

    /*************************
     * Constructor
     *************************/
    public User(String login, String pass){
        this.login = login;
        this.pass = pass;
        int N = 1024;
        rsa = new RSA();
        rsa.init(N);

        File folder = new File("resources/" + login);
        folder.mkdir();


        //fileName = "test.txt";
        //out = new PrintWriter(new FileWriter(folder.toString() + "/" +
            //fileName));
        //BigInteger decryptMessage = rsa.decrypt(pass);
    }
    public User(String login, BigInteger pass, BigInteger key, BigInteger modules){
        rsa = new RSA();

        rsa.setModulus(modules);
        rsa.setPublicKey(key);

        _pass = rsa.encrypt(pass);

        File folder = new File("resources/" + login + count);
        folder.mkdir();
    }
    public User(String login, BigInteger key, BigInteger modules){
        this.login = login;
        this.key = key;
        this.modules = modules;
    }
    /*************************
     * Methods
     *************************/
    public ArrayList<Tradition> getList(){
        return list;
    }
    //rsa.getPublicKey() и rsa.getModulus()
    void setPublicKey(BigInteger value){
        rsa.setPublicKey(value);
    }
    void setModules(BigInteger value){
        rsa.setModulus(value);
    }
    public BigInteger getPass(){
        return _pass;
    }
    public void setCount(){
        this.count++;
    }
}
