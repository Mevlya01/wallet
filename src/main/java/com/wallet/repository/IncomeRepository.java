package com.wallet.repository;

import com.wallet.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income,Long> {
    @Override
    boolean existsById(Long aLong);
}
