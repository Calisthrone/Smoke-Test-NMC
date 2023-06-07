package entity;

public record Product(
        String search_EN,
        String fullName_EN,
        String position,
        String price,
        String sku,
        String search_AR,
        String fullName_AR) {}