package com.example.seribit.controller;

import com.example.seribit.dto.VoucherDTO;
import com.example.seribit.dto.javaxgroups.CreateGroup;
import com.example.seribit.entity.Voucher;
import com.example.seribit.service.VoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seribit-api/vouchers")
public class VoucherController {

    private final VoucherService voucherService;

    @GetMapping("/{voucherId}")
    public ResponseEntity<VoucherDTO> getVoucherById(@PathVariable Integer voucherId) {
        return ResponseEntity.ok().body(voucherService.getVoucherDTOById(voucherId));
    }

    @GetMapping
    public ResponseEntity<List<VoucherDTO>> getAllVouchers() {
        return ResponseEntity.ok().body(voucherService.getAllVouchers());
    }

    @PostMapping
    public ResponseEntity<VoucherDTO> createVoucher(@RequestBody
                                                    @Validated(CreateGroup.class)
                                                    VoucherDTO voucherDTO) {
        VoucherDTO newVoucher = voucherService.createVoucher(voucherDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newVoucher.getVoucherId())
                .toUri();

        return ResponseEntity.created(uri).body(newVoucher);
    }

    @DeleteMapping("/{voucherId}")
    public ResponseEntity<Voucher> deleteVoucher(@PathVariable Integer voucherId) {
        voucherService.deleteVoucher(voucherId);
        return ResponseEntity.noContent().build();
    }
}
