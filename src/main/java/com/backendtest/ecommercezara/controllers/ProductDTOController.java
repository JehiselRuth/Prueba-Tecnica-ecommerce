package com.backendtest.ecommercezara.controllers;

import java.net.URI;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backendtest.ecommercezara.dtos.ProductDTO;
import com.backendtest.ecommercezara.models.Brand;
import com.backendtest.ecommercezara.models.DateSet;
import com.backendtest.ecommercezara.models.Price;
import com.backendtest.ecommercezara.services.BrandServiceImpl;
import com.backendtest.ecommercezara.services.DateSetServiceImpl;
import com.backendtest.ecommercezara.services.PriceServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductDTOController {

    @Autowired
    private PriceServiceImpl priceService;
    @Autowired
    private BrandServiceImpl brandService;
    @Autowired
    private DateSetServiceImpl dateService;
  
    @Autowired
    private ModelMapper modelMapper;

    public ProductDTOController(PriceServiceImpl priceService, BrandServiceImpl brandService,
            DateSetServiceImpl dateService, ModelMapper modelMapper) {
        this.priceService = priceService;
        this.brandService = brandService;
        this.dateService = dateService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/product")
    public ProductDTO getPriceDateBrand() {

        Price price = priceService.findById(1L).orElseThrow();
        DateSet date = dateService.findById(1L).orElseThrow();
        Brand brand = brandService.findById(1L).orElseThrow();

        ProductDTO dto = modelMapper.map(price, ProductDTO.class);
        modelMapper.map(date, dto);
        modelMapper.map(brand, dto);

        return dto;
    }

    @GetMapping("/product/{id}")
    public ProductDTO getPriceDateBrandById() {
        Price price = priceService.findById(1L).orElseThrow();
        DateSet date = dateService.findById(1L).orElseThrow();
        Brand brand = brandService.findById(1L).orElseThrow();

        ProductDTO dto = modelMapper.map(price, ProductDTO.class);
        modelMapper.map(date, dto);
        modelMapper.map(brand, dto);

        return dto;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        Price price = modelMapper.map(productDTO, Price.class);
        DateSet date = modelMapper.map(productDTO, DateSet.class);
        Brand brand = modelMapper.map(productDTO, Brand.class);

        priceService.save(price);
        dateService.save(date);
        brandService.save(brand);
        if (price.getProduct_id() == 3455 && brand.getBrand_id() == 1 &&
                date.getDate().equals("2020-06-14-00.00.00")) {
            price.setProduct_id(3455);
            brand.setBrand_id(1);
            price.setPrice_list(1);
            date.setDate("Start date: 2020-06-14-00.00.00 - End date: 2020-12-31-23.59.59");
        }
        return new ResponseEntity<>(
                modelMapper.map(priceService.save(modelMapper.map(productDTO, Price.class)), ProductDTO.class),
                HttpStatus.OK);

    }

    @PostMapping("/prices")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createPriceDateBrand(@RequestBody ProductDTO dto) {
        Price price = modelMapper.map(dto, Price.class);
        DateSet date = modelMapper.map(dto, DateSet.class);
        Brand brand = modelMapper.map(dto, Brand.class);

        priceService.save(price);
        dateService.save(date);
        brandService.save(brand);

        if (price.getProduct_id() == 3455 && brand.getBrand_id() == 1 &&
                date.getDate().equals("2020-06-14-00.00.00")) {
            price.setProduct_id(3455);
            brand.setBrand_id(1);
            price.setPrice_list(1);
            date.setDate("Start date: 2020-06-14-00.00.00 - End date: 2020-12-31-23.59.59");
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(price.getId()).toUri();

                System.out.println(location.toString());
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Price> updateProduct(@PathVariable(value = "id") Long productId,
            @RequestBody Price updatedPrice) {
        Optional<Price> product = priceService.findById(productId);
        if (product.isPresent()) {
            Price existentProduct = product.get();
            existentProduct.setProduct_id(updatedPrice.getProduct_id());
            existentProduct.setPrice_list(updatedPrice.getPrice_list());
            existentProduct.setPrice(updatedPrice.getPrice());
            existentProduct.setPriority(updatedPrice.getPriority());
            existentProduct.setCurrency(updatedPrice.getCurrency());

            Price updatedProductOnDB = priceService.save(existentProduct);
            return ResponseEntity.ok(updatedProductOnDB);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/brands/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable(value = "id") Long brandId,
            @RequestBody Brand updatedBrand) {
        Optional<Brand> brand = brandService.findById(brandId);
        if (brand.isPresent()) {
            Brand existentBrand = brand.get();
            existentBrand.setBrand_id(updatedBrand.getBrand_id());
            existentBrand.setBrand_name(updatedBrand.getBrand_name());

            Brand updatedBrandOnDB = brandService.save(existentBrand);
            return ResponseEntity.ok(updatedBrandOnDB);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/dates/{id}")
    public ResponseEntity<DateSet> updateDate(@PathVariable(value = "id") Long dateId,
            @RequestBody DateSet updatedDate) {
        Optional<DateSet> date = dateService.findById(dateId);
        if (date.isPresent()) {
            DateSet existentDate = date.get();
            existentDate.setDate(updatedDate.getDate());

            DateSet updatedDateOnDB = dateService.save(existentDate);
            return ResponseEntity.ok(updatedDateOnDB);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
