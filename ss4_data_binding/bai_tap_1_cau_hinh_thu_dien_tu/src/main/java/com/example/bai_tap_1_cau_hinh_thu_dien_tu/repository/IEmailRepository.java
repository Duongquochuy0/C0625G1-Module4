package com.example.bai_tap_1_cau_hinh_thu_dien_tu.repository;

import com.example.bai_tap_1_cau_hinh_thu_dien_tu.entity.EmailSetting;

public interface IEmailRepository {
    EmailSetting getSetting();
    void update(EmailSetting setting);
}
