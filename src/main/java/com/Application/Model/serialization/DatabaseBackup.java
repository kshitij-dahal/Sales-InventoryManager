package com.Application.Model.serialization;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.Application.Model.inventory.Item;
import com.Application.Model.store.SalesLog;
import com.Application.Model.store.SalesLogImpl;
import com.Application.Model.users.User;
import com.Application.Model.store.Account;
import com.Application.Model.store.Sale;


public class DatabaseBackup implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -5906534830386784100L;
  private LinkedHashMap<Integer, String> UserPw = new LinkedHashMap<Integer, String>();
  private List<Sale> Sales = new ArrayList<Sale>();
  private List<User> Users = new ArrayList<User>();
  private LinkedHashMap<Integer, Integer> UserRole = new LinkedHashMap<Integer, Integer>();
  private SalesLog ItimizedSales = new SalesLogImpl();
  private List<Item> Items = new ArrayList<Item>();
  private LinkedHashMap<Integer, List<Account>> AccountSummary =
      new LinkedHashMap<Integer, List<Account>>();
  private List<Account> Account = new ArrayList<Account>();
  private List<String> Roles = new ArrayList<String>();
  private LinkedHashMap<Integer, Integer> Inventory = new LinkedHashMap<Integer, Integer>();

  public void setUserPw(LinkedHashMap<Integer, String> UserPw) {
    this.UserPw = UserPw;
  }

  public LinkedHashMap<Integer, String> getUserPw() {
    return UserPw;
  }

  public void setSales(List<Sale> Sales) {
    this.Sales = Sales;
  }

  public List<Sale> getSales() {
    return Sales;
  }

  public void setUsers(List<User> Users) {
    this.Users = Users;
  }

  public List<User> getUsers() {
    return Users;
  }

  public void setUserRole(LinkedHashMap<Integer, Integer> UserRole) {
    this.UserRole = UserRole;
  }

  public LinkedHashMap<Integer, Integer> getUserRole() {
    return UserRole;
  }

  public void setItimizedSales(SalesLog ItimizedSales) {
    this.ItimizedSales = ItimizedSales;
  }

  public SalesLog getItimizedSales() {
    return ItimizedSales;
  }

  public void setItems(List<Item> Items) {
    this.Items = Items;
  }

  public List<Item> getItems() {
    return Items;
  }

  public void setAccountSummary(LinkedHashMap<Integer, List<Account>> AccountSummary) {
    this.AccountSummary = AccountSummary;
  }

  public LinkedHashMap<Integer, List<Account>> getAccountSummary() {
    return AccountSummary;
  }

  public void setAccount(List<Account> Account) {
    this.Account = Account;
  }

  public List<Account> getAccount() {
    return Account;
  }

  public void setRoles(List<String> Roles) {
    this.Roles = Roles;
  }

  public List<String> getRoles() {
    return Roles;
  }

  public void setInventory(LinkedHashMap<Integer, Integer> Inventory) {
    this.Inventory = Inventory;
  }

  public LinkedHashMap<Integer, Integer> getInventory() {
    return Inventory;
  }

}
