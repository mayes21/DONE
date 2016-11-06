package com.amabb.done.controller;

import com.amabb.done.model.Imputation;
import com.amabb.done.service.ImputationService;
import com.amabb.done.utils.csv.CSVList;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by amayas on 25/09/16.
 */

@Controller
@RequestMapping("/")
public class ImputationController {

    private static final Logger _log = Logger.getLogger(ImputationController.class);

    ImputationService imputationService;

    MessageSource messageSource;


    JavaMailSender mailSender;


    @Autowired
    public ImputationController(ImputationService imputationService, MessageSource messageSource, JavaMailSender mailSender) {
        Assert.notNull(imputationService);
        Assert.notNull(messageSource);
        Assert.notNull(mailSender);
        this.imputationService = imputationService;
        this.messageSource = messageSource;
        this.mailSender = mailSender;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String newImputation(ModelMap model) {

        Imputation imputation = new Imputation();
        model.addAttribute("imputation", imputation);

        return "addImput";
    }

    /*
     * This method will be called on form submission, handling POST request
     * It also validates the user input
     */
    @RequestMapping(method = RequestMethod.POST)
    public String saveImputation(@Valid Imputation imputation, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "addImput";
        }

        imputationService.saveImputation(imputation);
        return "addImput";
    }

    @RequestMapping(value = "/download/imputations", method = RequestMethod.GET)
    public void downloadCsvFile(HttpServletResponse httpServletResponse) {

        CSVList<Imputation> imputationsCSV = null;
        try {
            List<Imputation> imputations = imputationService.listAllImputations();
            imputationsCSV = new CSVList<>();
            imputationsCSV.addAll(imputations);
        } catch (Exception e) {
            _log.error("error creating csv");
            _log.error(e.getMessage());
        }

        String csvFileName = "imputations" + dateOfToday() + ".csv";
        buildCSVFile(httpServletResponse, csvFileName, imputationsCSV);

        FileSystemResource csvFile = new FileSystemResource(csvFileName);
        try {
            assert imputationsCSV != null;
            csvFile.getOutputStream().write(imputationsCSV.toCSV().getBytes("UTF-8"));
        } catch (IOException | IllegalAccessException e) {
            _log.error(">>>> CREATING FILE <<<<");
            _log.error(e.getMessage());
        }

        String mailFrom = "test@test.com";
        String mailTo = "amayas@yopmail.com";
        String subject = "TEST";

        sendEmail(mailFrom, mailTo, subject, csvFile);
    }

    private String dateOfToday() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("ddMMyyyy");
        return date.toString(fmt);
    }

    private void buildCSVFile(HttpServletResponse httpServletResponse, String csvFileName, CSVList<?> csvList) {
        httpServletResponse.setContentType("text/csv");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
        httpServletResponse.setHeader(headerKey, headerValue);
        httpServletResponse.setCharacterEncoding("UTF-8");
        try {
            httpServletResponse.getWriter().write(csvList.toCSV());
        } catch (IOException | IllegalAccessException ioe) {
            _log.error("error building csv file");
            _log.error(ioe.getMessage());
        }
    }

    private void sendEmail(String from, String to, String Subject, FileSystemResource attachment) {

        mailSender.send(new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                messageHelper.setFrom(from);
                messageHelper.setTo(to);
                messageHelper.setSubject(Subject);
                messageHelper .setText("test test test amayas");

                messageHelper.addAttachment("testAttach.csv", attachment);

            }
        });
    }
}