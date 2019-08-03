package com.xxx.mapper;

import com.xxx.po.Record;

public interface RecordMapper {
    int insert(Record record);
    Record selectById(int id);
}