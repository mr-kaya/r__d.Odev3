package org.mustafakaya.odev3.Repository;

import org.mustafakaya.odev3.Core.DTO.ProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductDto> {
    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductDto productDto = new ProductDto();
        productDto.setId(rs.getLong("id"));
        productDto.setCategory(rs.getString("category"));
        productDto.setName(rs.getString("name"));
        productDto.setDescription(rs.getString("description"));
        productDto.setPrice(rs.getDouble("price"));
        productDto.setPhotoUrl(rs.getString("photo_url"));

        return productDto;
    }
}
