package com.wallet.repository;

import com.wallet.entity.Category;
import com.wallet.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e")
    BigDecimal getTotalExpenseAmount();

    @Query("SELECT COALESCE(SUM(e.amount),0) FROM Expense e WHERE e.category.id = :categoryId")
    BigDecimal getTotalExpenseByCategory(Long categoryId);
}
