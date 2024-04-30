package com.example.seribit.service;

import com.example.seribit.dto.VoucherDTO;
import com.example.seribit.entity.Product;
import com.example.seribit.entity.Voucher;
import com.example.seribit.exception.EntityNotFoundException;
import com.example.seribit.mapper.VoucherMapper;
import com.example.seribit.repository.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoucherService {

    private final VoucherRepository voucherRepository;
    private final ProductService productService;
    private final VoucherMapper voucherMapper;

    public VoucherDTO getVoucherDTOById(Integer voucherId) {
        Voucher voucher = getVoucherById(voucherId);

        return VoucherDTO.builder()
                         .voucherId(voucher.getVoucherId())
                         .total(voucher.getTotal())
                         .quantity(voucher.getQuantity())
                         .createdAt(voucher.getCreatedAt())
                         .productId(voucher.getProduct().getProductId())
                         .build();
    }

    public Voucher getVoucherById(Integer voucherId) {
        Optional<Voucher> voucherOptional = voucherRepository.findById(voucherId);
        return voucherOptional.orElseThrow(() -> new EntityNotFoundException("O voucher não foi encontrado!"));
    }

    public List<VoucherDTO> getAllVouchers() {
        List<Voucher> allVouchers = voucherRepository.findAll();

        return allVouchers.stream().map(voucher ->
                VoucherDTO.builder()
                          .voucherId(voucher.getVoucherId())
                          .total(voucher.getTotal())
                          .quantity(voucher.getQuantity())
                          .createdAt(voucher.getCreatedAt())
                          .productId(voucher.getProduct().getProductId())
                          .build()
        ).collect(Collectors.toList());
    }

    public VoucherDTO createVoucher(VoucherDTO voucherDTO) {
        Product product = productService.getProductById(voucherDTO.getProductId());
        Voucher mappedEntity = voucherMapper.mapFromDtoToEntity(voucherDTO, product);
        Voucher newVoucher = voucherRepository.save(mappedEntity);

        voucherDTO.setVoucherId(newVoucher.getVoucherId());
        voucherDTO.setCreatedAt(newVoucher.getCreatedAt());
        voucherDTO.setTotal(newVoucher.getTotal());
        voucherDTO.setQuantity(newVoucher.getQuantity());
        voucherDTO.setProductId(newVoucher.getProduct().getProductId());

        return voucherDTO;
    }

    public void deleteVoucher(Integer voucherId) {
        Voucher voucher = getVoucherById(voucherId);
        voucherRepository.delete(voucher);
    }
}
