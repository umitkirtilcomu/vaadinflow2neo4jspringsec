package com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.UploadI18N;
import com.vaadin.flow.server.StreamResource;
import org.apache.commons.io.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StaticFunctions {

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        if (dateToConvert == null) return null;
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static Date convertToDateViaInstant(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static String ifStringNullMakeItEmpty(String str) {
        if (str == null || str.isEmpty()) return "";
        return str;
    }

    public static Notification notificationShow(String msg, NotificationVariant notificationVariant) {
        HorizontalLayout vL = new HorizontalLayout();
        vL.setAlignItems(FlexComponent.Alignment.CENTER);
        vL.setSizeFull();
        vL.setSpacing(true);

        Label content = new Label(msg);
        content.setSizeUndefined();

        vL.add(content);
        Notification notification = new Notification(vL);
        notification.setDuration(50000);
        notification.setPosition(Notification.Position.BOTTOM_STRETCH);
        notification.addThemeVariants(notificationVariant);

        vL.addClickListener(horizontalLayoutClickEvent -> {
            notification.close();
        });

        notification.setOpened(true);
        return notification;
    }

    public static Locale trLocale() {
        return new Locale("tr", "TR");
    }

    public static DatePicker.DatePickerI18n getDatePickerI18N() {
        DatePicker.DatePickerI18n datePickerI18n = new DatePicker.DatePickerI18n();
        datePickerI18n.setCalendar("Takvim");
        datePickerI18n.setCancel("İptal Et");
        datePickerI18n.setClear("Temizle");
        datePickerI18n.setFirstDayOfWeek(1);
        datePickerI18n.setMonthNames(Arrays.asList("OCAK", "ŞUBAT", "MART", "NİSAN", "MAYIS", "HAZİRAN", "TEMMUZ", "AĞUSTOS", "EYLÜL", "EKİM", "KASIM", "ARALIK"));
        datePickerI18n.setToday("Bugün");
        datePickerI18n.setWeek("Hafta");
        datePickerI18n.setWeekdays(Arrays.asList("PAZAR", "PAZARTESİ", "SALI", "ÇARŞAMBA", "PERŞEMBE", "CUMA", "CUMARTESİ"));
        datePickerI18n.setWeekdaysShort(Arrays.asList("PZ", "PT", "SA", "CA", "PE", "CU", "CT"));

        return datePickerI18n;
    }

    /*public static KisiBilgisiMernis getKisiBilgileri(String tcKimlik) throws ParseException, TCMernisteBulunamadiException {
        HttpResponse<String> response = Unirest.post("https://api.comu.edu.tr/kps/kisi/" + tcKimlik)
                .header("x-api-key", "02090B3B3C1E157A6B2D19F03353D623")
                .header("cache-control", "no-cache")
                .asString();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody());

        if (jsonObject.get("code").equals(400l)) throw new TCMernisteBulunamadiException();

        JSONObject temelBilgileriObject = ((JSONObject) ((JSONObject) ((JSONObject) jsonObject.get("data")).get("KisiBilgisi")).get("TemelBilgisi"));

        KisiBilgisiMernis kisiBilgisiMernis = new KisiBilgisiMernis();

        kisiBilgisiMernis.setAdi(temelBilgileriObject.get("Ad").toString());
        kisiBilgisiMernis.setSoyadi(temelBilgileriObject.get("Soyad").toString());
        kisiBilgisiMernis.setAnneAdi(temelBilgileriObject.get("AnneAd").toString());
        kisiBilgisiMernis.setBabaAdi(temelBilgileriObject.get("BabaAd").toString());

        JSONObject cinsiyetObject = (JSONObject) temelBilgileriObject.get("Cinsiyet");
        String cinsiyet = cinsiyetObject.get("Aciklama").toString();

        kisiBilgisiMernis.setCinsiyet(cinsiyet);
        return kisiBilgisiMernis;
    }*/

    public static void setScrollableTrue(VerticalLayout verticalLayout) {
        verticalLayout.getStyle().set("overflow", "auto");
        verticalLayout.getStyle().set("display", "block");
    }

    public static StreamResource getYerelUserImage(String tc) {
        String userImagePath = "/userImages/" + tc + ".jpg";
        File userImageFile = new File(userImagePath);

        try {
            byte[] imageBytes = FileUtils.readFileToByteArray(userImageFile);
            StreamResource resource = new StreamResource(tc + ".jpg", () -> new ByteArrayInputStream(imageBytes));
            return resource;
        } catch (IOException e) {
            return null;
        }
    }

    public static UploadI18N getUploadI18N() {
        UploadI18N i18n = new UploadI18N();
        i18n.setDropFiles(
                new UploadI18N.DropFiles().setOne("Dosya Yükle...")
                        .setMany("Dosyalari Seçiniz..."))
                .setAddFiles(new UploadI18N.AddFiles()
                        .setOne("Dosya Ekle").setMany("Dosyalar Ekle"))
                .setCancel("İptal")
                .setError(new UploadI18N.Error()
                        .setTooManyFiles("Çok Fazla Dosya !")
                        .setFileIsTooBig("Çok Büyük Dosya !")
                        .setIncorrectFileType("Hatalı Dosya Türü !"))
                .setUploading(new UploadI18N.Uploading()
                        .setStatus(new UploadI18N.Uploading.Status()
                                .setConnecting("Bağlanıyor...")
                                .setStalled("Durduruldu.")
                                .setProcessing("İşleniyor..."))
                        .setRemainingTime(
                                new UploadI18N.Uploading.RemainingTime()
                                        .setPrefix("Kalan Süre: ")
                                        .setUnknown(
                                                "hesaplanamıyor"))
                        .setError(new UploadI18N.Uploading.Error()
                                .setServerUnavailable("Sunucu Çevrimdışı")
                                .setUnexpectedServerError(
                                        "Beklenmedik Hata")
                                .setForbidden("Engellendi")))
                .setUnits(Stream
                        .of("Б", "Кбайт", "Мбайт", "Гбайт", "Тбайт", "Пбайт",
                                "Эбайт", "Збайт", "Ибайт")
                        .collect(Collectors.toList()));
        return i18n;
    }
}
