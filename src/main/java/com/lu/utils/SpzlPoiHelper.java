package com.lu.utils;

import com.alibaba.fastjson.JSON;
import com.lu.domain.Spzl;
import org.apache.poi.ss.usermodel.*;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wuzhong on 16/1/29.
 */
public class SpzlPoiHelper {

    public List<Spzl> convert(InputStream inputStream) {

        try {
            List<Spzl> list = new ArrayList<>();

            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(workbook.getNumberOfSheets() - 1);

            Iterator<Row> rowIterator = sheet.iterator();

            int cellIndex = 0;

            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();

                if (0 == cellIndex++) {
                    continue;
                }

                Iterator<Cell> cellIterator = row.cellIterator();

                Spzl spzl = new Spzl();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            spzl.setSpbh(getStringValue(cell));
                            break;
                        case 1:
                            spzl.setJzkh(getStringValue(cell));
                            break;
                        case 2:
                            spzl.setWxhth(getStringValue(cell));
                            break;
                        case 3:
                            spzl.setHuohao(getStringValue(cell));
                            break;
                        case 4:
                            spzl.setKehao(getStringValue(cell));
                            break;
                        case 5:
                            spzl.setZrkf(getStringValue(cell));
                            break;
                        case 6:
                            spzl.setSjpfusd(getDouble(cell));
                            break;
                        case 7:
                            spzl.setSprq(getTime(cell));
                            break;
                        case 8:
                            spzl.setSpyy(getStringValue(cell));
                            break;
                        case 9:
                            spzl.setLrrq(getTime(cell));
                            break;
                        case 10:
                            spzl.setPm(getStringValue(cell));
                            break;
                        case 11:
                            spzl.setLrr(getStringValue(cell));
                            break;
                        case 12:
                            spzl.setBm(getStringValue(cell));
                            break;
                        case 13:
                            spzl.setBmcdusd(getDouble(cell));
                            break;
                        case 14:
                            spzl.setSpzrr(getStringValue(cell));
                            break;
                        case 15:
                            spzl.setClr(getStringValue(cell));
                            break;
                        case 16:
                            spzl.setYyfx(getStringValue(cell));
                            break;
                        case 17:
                            spzl.setFycs(getStringValue(cell));
                            break;
                        case 18:
                            spzl.setSjgc(getStringValue(cell));
                            break;
                        case 19:
                            spzl.setYpfje(getDouble(cell));
                            break;
                        case 20:
                            spzl.setGcpfqr(getStringValue(cell));
                            break;
                        case 21:
                            spzl.setGcsjpf(getDouble(cell));
                            break;
                        case 22:
                            spzl.setGcpfrq(getTime(cell));
                            break;
                        case 23:
                            spzl.setNxhth(getStringValue(cell));
                            break;

                    }
                }

                list.add(spzl);

                System.out.println(JSON.toJSONString(spzl));
            }

            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getStringValue(Cell cell) {
        String value = cell.toString();
        if(null != value && value.endsWith(".0")){
            return value.substring(0,value.length()-2);
        }
        return value;
    }

    private double getDouble(Cell cell) {
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return cell.getNumericCellValue();
        } else {
            try {
                String a = cell.toString();
                return Double.valueOf(a);
            } catch (Throwable e) {
                return 0.0;
            }
        }
    }

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private long getTime(Cell cell) {

        try {
            if (cell.getCellType() != Cell.CELL_TYPE_STRING) {
                return cell.getDateCellValue().getTime();
            }

            String value = cell.toString();
            if (!StringUtils.isEmpty(value)) {
                return simpleDateFormat.parse(value).getTime();
            }
        } catch (Throwable e) {

        }
        return 0;
    }

}
