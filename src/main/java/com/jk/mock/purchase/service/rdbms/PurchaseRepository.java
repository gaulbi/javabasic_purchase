package com.jk.mock.purchase.service.rdbms;

import com.jk.mock.purchase.bean.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, String> {
}
