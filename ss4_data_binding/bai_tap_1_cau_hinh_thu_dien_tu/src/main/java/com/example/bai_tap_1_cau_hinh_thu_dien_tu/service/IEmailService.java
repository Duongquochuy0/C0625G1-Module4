package com.example.bai_tap_1_cau_hinh_thu_dien_tu.service;

import com.example.bai_tap_1_cau_hinh_thu_dien_tu.entity.EmailSetting;

public interface IEmailService {
    EmailSetting getSetting();
    void update(EmailSetting setting);
}
