package com.example.bai_tap_1_cau_hinh_thu_dien_tu.repository;

import com.example.bai_tap_1_cau_hinh_thu_dien_tu.entity.EmailSetting;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepository implements IEmailRepository {
    private EmailSetting setting = new EmailSetting("Vietnamese", 5, true, "Huy, Dương Quốc Huy");
    @Override
    public EmailSetting getSetting() {
        return setting;
    }

    @Override
    public void update(EmailSetting setting) {
        this.setting = setting;
    }
}
