/**
 * Copyright (c) 2023 Drishti-Soft Solutions Pvt. Ltd.
 *
 * @author: nikhilsrivastava
 * Date:  Nov 7, 2023
 */
package com.ameyo.configuration.services.dagenturiresolver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lombok.Data;

@Data
class Coupon {
    private String categoryName;
    private String couponName;
    private String date;
    private String discount;

    public Coupon(String categoryName, String couponName, String date, String discount) {
        this.categoryName = categoryName;
        this.couponName = couponName;
        this.date = date;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return this.couponName + this.date + this.discount;
    }

}

class CouponFinder {
    private Map<String, List<Coupon>> coupons;
    private Map<String, String> categoryVsParentCategory;
    private Map<String, TreeMap<String, Coupon>> categorizedCoupons;

    public CouponFinder(List<Map<String, String>> coupons, List<Map<String, String>> categories) {
        this.coupons = new HashMap<>();
        this.categoryVsParentCategory = new HashMap<>();
        this.categorizedCoupons = new HashMap<>();

        for (Map<String, String> c : coupons) {
            String categoryName = c.get("Category Name");
            Coupon coupon = new Coupon(categoryName, c.get("Coupon Name"), c.get("Date Modified"), c.get("Discount"));

            if (!categorizedCoupons.containsKey(categoryName)
                    || !this.coupons.containsKey(categoryName)/*ye wala he likhna hai pehle to bs fir ye hata denge*/) {
                categorizedCoupons.put(categoryName, new TreeMap<>());
                this.coupons.put(categoryName, new ArrayList<Coupon>());
            }
            categorizedCoupons.get(categoryName).put(c.get("Date Modified") + c.get("Coupon Name"), coupon);
            this.coupons.get(categoryName).add(coupon);
        }

        for (Map<String, String> c : categories) {
            this.categoryVsParentCategory.put(c.get("Category Name"), c.get("Category Parent Name"));
        }
    }

    public Coupon getBestCoupon(String categoryName) {

        //PEHLE YAHI KRNA HAI RETURN fir else if categorized wala baad me
        if (this.coupons.containsKey(categoryName)) {
            System.out.println("nikkk " + this.coupons.get(categoryName).stream().findAny().get().getCouponName());
        }

        if (categorizedCoupons.containsKey(categoryName)) {
            TreeMap<String, Coupon> categoryCoupons = categorizedCoupons.get(categoryName);

            LocalDate currentDate = LocalDate.now();
            LocalDate specifiedDate = LocalDate.parse("1990-01-01");

            Coupon bestCoupon = null;

            for (Map.Entry<String, Coupon> entry : categoryCoupons.entrySet()) {
                Coupon coupon = entry.getValue();
                LocalDate currCouponDate = LocalDate.parse(coupon.getDate());

                if (currCouponDate.isAfter(specifiedDate) && !currCouponDate.isAfter(currentDate)) {
                    if (bestCoupon == null || currCouponDate.isAfter(LocalDate.parse(bestCoupon.getDate()))) {
                        bestCoupon = coupon;
                    }
                }
            }

            return bestCoupon;
        } else if (this.categoryVsParentCategory.containsKey(categoryName)) {
            return getBestCoupon(this.categoryVsParentCategory.get(categoryName));
        } else {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        /*List<Map<String, String>> Coupons = new ArrayList<>();
        Coupons.add(new HashMap<String, String>() {
            {
                put("Category Name", "Comforter Sets");
                put("Coupon Name", "Comforters Sale");
            }
        });
        Coupons.add(new HashMap<String, String>() {
            {
                put("Category Name", "Bedding");
                put("Coupon Name", "Savings on Bedding");
            }
        });*/
        //Coupons.add(Map.of("Category Name", "Bed & Bath", "Coupon Name", "Low price for Bed & Bath"));

        //Coupons.add(createCouponEntry("Bed & Bath", "Low price for Bed & Bath"));
        List<Map<String, String>> coupons = new ArrayList<>();
        coupons.add(createCouponEntry("Comforter Sets", "Comforters sale", "2020-01-01", "10%"));
        coupons.add(createCouponEntry("Comforter Sets", "Cozy Comforter Coupon", "2020-01-01", "$15"));
        coupons.add(createCouponEntry("Bedding", "Best Bedding Bargains", "2019-01-01", "35%"));
        coupons.add(createCouponEntry("Bedding", "Savings on Bedding", "2019-01-01", "25%"));
        coupons.add(createCouponEntry("Bed & Bath", "Low price for Bed & Bath", "2018-01-01", "50%"));
        coupons.add(createCouponEntry("Bed & Bath", "Bed & Bath extravaganza", "2019-01-01", "75%"));
        coupons.add(createCouponEntry("Bed & Bath", "Big Savings for Bed & Bath", "2030-01-01", "65%"));

        List<Map<String, String>> Categories = new ArrayList<>();
        Categories.add(createCategoryEntry("Comforter Sets", "Bedding"));
        Categories.add(createCategoryEntry("Bedding", "Bed & Bath"));
        Categories.add(createCategoryEntry("Bed & Bath", null));
        Categories.add(createCategoryEntry("Soap Dispensers", "Bathroom Accessories"));
        Categories.add(createCategoryEntry("Bathroom Accessories", "Bed & Bath"));
        Categories.add(createCategoryEntry("Toy Organizers", "Baby And Kids"));
        Categories.add(createCategoryEntry("Baby And Kids", null));

        //If asked for discounts with products
        List<Map<String, String>> Products = new ArrayList<>();
        Products.add(createProductEntry("Cozy Comforter", "100.00", "Comforter Sets"));
        Products.add(createProductEntry("All-in-one Bedding Set", "50.00", "Bedding"));
        Products.add(createProductEntry("Infinite Soap Dispenser", "500.00", "Bathroom Accessories"));
        Products.add(createProductEntry("Rainbow Toy Box", "257.00", "Baby And Kids"));

        CouponFinder finder = new CouponFinder(coupons, Categories);
        System.out.println("Started");
        Coupon currentCoup = finder.getBestCoupon("Bathroom Accessories");
        System.out.println(currentCoup != null ? currentCoup.getCouponName() : null);
        System.out.println("Ended");

        //if products are also there and you have to apply discounts as well.
        for (Map<String, String> map : Products) {
            System.out.println("product " + map.get("Product Name"));
            Coupon dis = finder.getBestCoupon(map.get("Category Name"));
            if (dis != null) {
                dis.setDiscount(dis.getDiscount().replaceAll("%", "").replaceAll("$", ""));
            } else {
                System.out.println(map.get("Price"));
                continue;
            }
            double price = Double.parseDouble(map.get("Price"));
            double discountPercentage = Double.parseDouble(dis.getDiscount());
            double discountedPrice = price - (discountPercentage * 0.01 * price);

            String formattedDiscountedPrice = String.format("%.2f", discountedPrice);
            System.out.println(formattedDiscountedPrice);
        }

    }

    public static Map<String, String> createCouponEntry(String categoryName, String couponName, String dateModified,
            String discount) {
        return new HashMap<String, String>() {
            {
                put("Category Name", categoryName);
                put("Coupon Name", couponName);
                put("Date Modified", dateModified);
                put("Discount", discount);
            }
        };
    }

    public static Map<String, String> createCategoryEntry(String categoryName, String categoryParentName) {
        return new HashMap<String, String>() {
            {
                put("Category Name", categoryName);
                put("Category Parent Name", categoryParentName);
            }
        };
    }

    public static Map<String, String> createProductEntry(String productName, String price, String categoryName) {
        return new HashMap<String, String>() {
            {
                put("Product Name", productName);
                put("Price", price);
                put("Category Name", categoryName);
            }
        };
    }

}
