package com.example.bai_tap_1_cau_hinh_thu_dien_tu.service;

import com.example.bai_tap_1_cau_hinh_thu_dien_tu.entity.EmailSetting;
import com.example.bai_tap_1_cau_hinh_thu_dien_tu.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

    private final IEmailRepository emailRepository;

    @Autowired
    public EmailService(IEmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public EmailSetting getSetting() {
        return emailRepository.getSetting();
    }

    @Override
    public void update(EmailSetting setting) {
        emailRepository.update(setting);
    }
}
