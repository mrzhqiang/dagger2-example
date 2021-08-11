package com.github.mrzhqiang.dagger2_example.db;

import androidx.annotation.Nullable;
import androidx.room.TypeConverter;

import com.github.mrzhqiang.helper.Dates;
import com.google.common.base.Strings;

import java.util.Date;

public enum DatabaseTypeConverters {
    ;

    @TypeConverter
    @Nullable
    public static Date fromFormat(@Nullable String value) {
        return Strings.isNullOrEmpty(value) ? null : Dates.parse(value);
    }

    @TypeConverter
    @Nullable
    public static String formatOf(@Nullable Date date) {
        return date == null ? null : Dates.format(date);
    }
}
