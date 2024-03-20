package com.example.seribit.mapper;

import com.example.seribit.dto.VoucherDTO;
import com.example.seribit.entity.Product;
import com.example.seribit.entity.Voucher;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class VoucherMapper {

    private final ModelMapper modelMapper;

    public Voucher mapFromDtoToEntity(VoucherDTO voucherDTO, Product product) {
        Voucher voucher = modelMapper.map(voucherDTO, Voucher.class);
        voucher.setProduct(product);
        voucher.setCreatedAt(LocalDateTime.now());
        voucher.setTotal(product.getPrice().multiply(BigDecimal.valueOf(voucherDTO.getQuantity())));
        return voucher;
    }

    public void updateEntity(VoucherDTO voucherDTO, Voucher voucher, Product product) {
        voucher.setTotal(voucherDTO.getTotal());
        voucher.setQuantity(voucher.getQuantity());
        voucher.setProduct(product);
    }
}
