package com.Application.Model.validator;

import com.Application.Model.database.helper.DatabaseDriverAndroidHelper;
import com.Application.Model.inventory.Item;
import com.Application.Model.store.Sale;
import com.Application.Model.store.SalesLog;
import java.math.BigDecimal;

public class ItemizedSalesValidator {

  private static DatabaseDriverAndroidHelper mydb;

  public static boolean validateSaleId(int saleId) {

    Sale sale = mydb.getSaleByIdH(saleId);
    return sale != null;
  }

  public static boolean validateItemId(int itemId) {
    Item item = mydb.getItemH(itemId);
    return item != null;
  }

  public static boolean validateQuantity(int quantity) {
    return quantity > 0;
  }

  public static boolean validateUniqueComb(int saleId, int itemId) {
    SalesLog saleslog = mydb.getItemizedSalesH();
    int count = 0;
    for (Sale sale : saleslog.getSales()) {
      if (sale.getId() == saleId) {
        for (Item item : sale.getItemMap().keySet()) {
          if (item.getId() == itemId) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static boolean validateTotalPrice(int saleId, int itemId, int quantity) {

    SalesLog saleslog = mydb.getItemizedSalesH();
    BigDecimal requiredTotal = mydb.getSaleByIdH(saleId).getTotalPrice();
    BigDecimal accumulator = new BigDecimal("0.00");
    for (Sale sale : saleslog.getSales()) {
      if (sale.getId() == saleId) {
        for (Item item : sale.getItemMap().keySet()) {
          accumulator = (item.getPrice().multiply(new BigDecimal(sale.getItemMap().get(item))))
              .add(accumulator);
        }
      }
    }
    return accumulator.compareTo(requiredTotal) <= 0;
  }

  public static void setContext(DatabaseDriverAndroidHelper db) {
    mydb = db;
  }
}
