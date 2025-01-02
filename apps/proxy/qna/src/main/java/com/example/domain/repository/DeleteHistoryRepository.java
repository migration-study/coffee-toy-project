package com.example.domain.repository;

import com.example.domain.entity.DeleteHistory;

import java.util.List;

public interface DeleteHistoryRepository {

    void saveAll(List<DeleteHistory> deleteHistories);
}
