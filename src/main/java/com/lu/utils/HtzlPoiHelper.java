package com.lu.utils;

import com.lu.domain.Htzl;
import org.apache.poi.ss.usermodel.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wuzhong on 16/1/29.
 */
public class HtzlPoiHelper {

    public List<Htzl> convert(InputStream inputStream) {

        try {
            List<Htzl> list = new ArrayList<>();

            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            int cellIndex = 0;

            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();

                if (0 == cellIndex++) {
                    continue;
                }

                Iterator<Cell> cellIterator = row.cellIterator();

                Htzl htzl = new Htzl();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            htzl.setKh(cell.getStringCellValue());
                            break;
                        case 1:
                            htzl.setKhddh(cell.toString());
                            break;
                        case 2:
                            htzl.setWxjq(cell.getDateCellValue().getTime());
                            break;
                        case 3:
                            htzl.setDdczy(cell.getStringCellValue());
                            break;
                        case 4:
                            htzl.setWxh(cell.toString());
                            break;
                        case 5:
                            htzl.setCgjq(cell.getDateCellValue().getTime());
                            break;
                        case 6:
                            htzl.setKehao(cell.toString());
                            break;
                        case 7:
                            htzl.setGchh(cell.toString());
                            break;
                        case 8:
                            //// TODO: 16/1/29
                            htzl.setXdrq(cell.getDateCellValue().getTime());
                            break;
                        case 9:
                            htzl.setCght(cell.getStringCellValue());
                            break;
                        case 10:
                            htzl.setGc(cell.getStringCellValue());
                            break;
                        case 11:
                            htzl.setCpms(cell.toString());
                            break;
                        case 12:
                            //TODO
                            htzl.setZxl(getDouble(cell));
                            break;
                        case 13:
                            htzl.setBzsm(cell.toString());
                            break;
                        case 14:
                            htzl.setWxj(cell.getNumericCellValue());
                            break;
                        case 15:
                            htzl.setCgj(cell.getNumericCellValue());
                            break;
                        case 16:
//                            System.out.println(cell.toString());
                            //TODO
                            htzl.setSl(cell.getNumericCellValue());
                            break;
                        case 17:
                            htzl.setJgtk(cell.toString());
                            break;
                        case 18:
                            Double d = cell.getNumericCellValue();
                            htzl.setHtxj(d.intValue());
                            break;
                        case 19:
                            //TODO
//                            htzl.setWxzj(cell.getStringCellValue());
                            break;
                        case 20:
                            //TODO
//                            htzl.setNxzj(cell.getStringCellValue());
                            break;
                        case 21:
                            htzl.setMll(cell.getNumericCellValue());
                            break;
                        case 22:
                            htzl.setBmmll(cell.getNumericCellValue());
                            break;

                    }
                }
                htzl.setWxzj(htzl.getWxj() * htzl.getSl());
                htzl.setNxzj(htzl.getCgj() * htzl.getSl());

                list.add(htzl);
            }

            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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

}
