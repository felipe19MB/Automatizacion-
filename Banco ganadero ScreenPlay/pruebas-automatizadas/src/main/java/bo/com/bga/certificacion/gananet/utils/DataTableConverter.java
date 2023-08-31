package bo.com.bga.certificacion.gananet.utils;


import io.cucumber.datatable.DataTable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataTableConverter {

    public static Collection<String> convert(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        return rows.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}

