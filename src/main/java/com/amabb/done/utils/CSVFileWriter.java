package com.amabb.done.utils;

import com.amabb.done.model.Imputation;
import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.util.List;

/**
 * Created by amayas on 02/10/16.
 */
@Component
public class CSVFileWriter {


    private static CellProcessor[] getProcessors() {

        final CellProcessor[] processors = new CellProcessor[] {
            new NotNull(), //timeSpent
                new NotNull(), //project
                new NotNull(), //task
                new Optional(), //status
                new NotNull() //date
        };

        return processors;
    }

    public static void writeWithCsvBeanWriter(List<Imputation> imputations) throws Exception {

        ICsvBeanWriter beanWriter = null;

        try {
            beanWriter = new CsvBeanWriter(new FileWriter("/home/amayas/dev/DONE/test.csv"), CsvPreference.EXCEL_PREFERENCE);

            //CSV FILE HEADER
            //final String[] header = new String[] {"TEMPS PASSÉ", "PROJET", "TÂCHE", "STATUT", "DATE"};
            final String[] header = new String[] {"timeSpent", "project", "task", "status", "date"};
            final CellProcessor[] processors = getProcessors();

            //WRITE THE HEADER
            beanWriter.writeHeader(header);

            //WRITE THE BEANS
            for (final Imputation imputation : imputations) {
                beanWriter.write(imputation, header, processors);
            }

        } finally {
            if( beanWriter != null ) {
                beanWriter.close();
            }
        }

    }
}
