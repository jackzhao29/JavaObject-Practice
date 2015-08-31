package com.coldface.code.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadWriteExcelUtils {
	
	/**
     *执行方法
     * @param args
     */
    public static void main(String[] args){
        readxls("test.xls");
    }
    /**
     * 读.xls后缀的文件
     * @param fileName
     */
    public static void readxls(String fileName){

        try{
            File file = new File(fileName);
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(file));
            HSSFWorkbook hssfWorkbook =  new HSSFWorkbook(poifsFileSystem);
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

            int rowstart = hssfSheet.getFirstRowNum();
            int rowEnd = hssfSheet.getLastRowNum();
            for(int i=rowstart;i<=rowEnd;i++)
            {
                HSSFRow row = hssfSheet.getRow(i);
                if(null == row) continue;
                int cellStart = row.getFirstCellNum();
                int cellEnd = row.getLastCellNum();
                String condition=null;
                String values=null;
                for(int k=cellStart;k<=cellEnd;k++)
                {
                    HSSFCell cell = row.getCell(k);
                    if(null==cell) continue;
                    switch (cell.getCellType())
                    {
                        case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                            //System.out.print(cell.getNumericCellValue()
                            //       + "   ");
                            break;
                        case HSSFCell.CELL_TYPE_STRING: // 字符串
                            if(k==3){
                                //System.out.print(formatDate(cell.getStringCellValue())
                                //      + "   ");
                                values=cell.getStringCellValue();
                            }else if(k==0){
                                //System.out.print(cell.getStringCellValue()
                                //        + "   ");
                                condition=cell.getStringCellValue();
                            }else{
                                //System.out.print(cell.getStringCellValue()
                                //       + "   ");
                            }

                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                            //System.out.println(cell.getBooleanCellValue()
                            //     + "   ");
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA: // 公式
                            System.out.print(cell.getCellFormula() + "   ");
                            break;
                        case HSSFCell.CELL_TYPE_BLANK: // 空值
                            //System.out.println(" ");
                            break;
                        case HSSFCell.CELL_TYPE_ERROR: // 故障
                            //System.out.println(" ");
                            break;
                        default:
                            System.out.print("未知类型   ");
                            break;
                    }

                }
                String sql="UPDATE table SET values="+values+", WHERE condition='"+condition+"';";
                System.out.println(sql);
            }
        }catch (Exception ex){
            System.out.println("Exception:"+ex);
        }
        System.out.println("处理完毕");

    }

    /**
     * 写xls文件
     */
    public void writeXls(String fileName){
        /**
        try {
            WritableWorkbook wwb = null;

            // 创建可写入的Excel工作簿
            File file=new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file);

            // 创建工作表
            WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

            //查询数据库中所有的数据
            List<StuEntity> list= StuService.getAllByDb();
            //要插入到的Excel表格的行号，默认从0开始
            Label labelId= new Label(0, 0, "编号(id)");//表示第
            Label labelName= new Label(1, 0, "姓名(name)");
            Label labelSex= new Label(2, 0, "性别(sex)");
            Label labelNum= new Label(3, 0, "薪水(num)");

            ws.addCell(labelId);
            ws.addCell(labelName);
            ws.addCell(labelSex);
            ws.addCell(labelNum);
            for (int i = 0; i < list.size(); i++) {

                Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
                Label labelName_i= new Label(1, i+1, list.get(i).getName());
                Label labelSex_i= new Label(2, i+1, list.get(i).getSex());
                Label labelNum_i= new Label(3, i+1, list.get(i).getNum()+"");
                ws.addCell(labelId_i);
                ws.addCell(labelName_i);
                ws.addCell(labelSex_i);
                ws.addCell(labelNum_i);
            }

            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            wwb.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         **/
    }

    /**
     * 读.Xlsx文件
     * @param fileName
     */
    public void readXlsx(String fileName){
        /**
        File file = new File(fileName);

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        int rowstart = xssfSheet.getFirstRowNum();
        int rowEnd = xssfSheet.getLastRowNum();
        for(int i=rowstart;i<=rowEnd;i++)
        {
            XSSFRow row = xssfSheet.getRow(i);
            if(null == row) continue;
            int cellStart = row.getFirstCellNum();
            int cellEnd = row.getLastCellNum();

            for(int k=cellStart;k<=cellEnd;k++)
            {
                XSSFCell cell = row.getCell(k);
                if(null==cell) continue;

                switch (cell.getCellType())
                {
                    case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                        System.out.print(cell.getNumericCellValue()
                                + "   ");
                        break;
                    case HSSFCell.CELL_TYPE_STRING: // 字符串
                        System.out.print(cell.getStringCellValue()
                                + "   ");
                        break;
                    case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                        System.out.println(cell.getBooleanCellValue()
                                + "   ");
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA: // 公式
                        System.out.print(cell.getCellFormula() + "   ");
                        break;
                    case HSSFCell.CELL_TYPE_BLANK: // 空值
                        System.out.println(" ");
                        break;
                    case HSSFCell.CELL_TYPE_ERROR: // 故障
                        System.out.println(" ");
                        break;
                    default:
                        System.out.print("未知类型   ");
                        break;
                }

            }
            System.out.print("\n");
        }
         **/
    }

    /**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */
    /**
    public static List<StuEntity> getAllByExcel(String file){
        List<StuEntity> list=new ArrayList<StuEntity>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("Shee1");//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行

            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String name=rs.getCell(j++, i).getContents();
                    String sex=rs.getCell(j++, i).getContents();
                    String num=rs.getCell(j++, i).getContents();

                    System.out.println("id:"+id+" name:"+name+" sex:"+sex+" num:"+num);
                    list.add(new StuEntity(Integer.parseInt(id), name, sex, Integer.parseInt(num)));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }
     **/

    /**
     * 将数据写入Excel表中
     */
    /**
    public void  dataWriteExcel(){
        try {
            WritableWorkbook wwb = null;

            // 创建可写入的Excel工作簿
            String fileName = "D://book.xls";
            File file=new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file);

            // 创建工作表
            WritableSheet ws = wwb.createSheet("Shee1", 0);

            //查询数据库中所有的数据
            List<StuEntity> list=new ArrayList<StuEntity>();
            //要插入到的Excel表格的行号，默认从0开始
            Label labelId= new Label(0, 0, "编号(id)");//表示第
            Label labelName= new Label(1, 0, "姓名(name)");
            Label labelSex= new Label(2, 0, "性别(sex)");
            Label labelNum= new Label(3, 0, "薪水(num)");

            ws.addCell(labelId);
            ws.addCell(labelName);
            ws.addCell(labelSex);
            ws.addCell(labelNum);
            for (int i = 0; i < list.size(); i++) {

                Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
                Label labelName_i= new Label(1, i+1, list.get(i).getName());
                Label labelSex_i= new Label(2, i+1, list.get(i).getSex());
                Label labelNum_i= new Label(3, i+1, list.get(i).getNum()+"");
                ws.addCell(labelId_i);
                ws.addCell(labelName_i);
                ws.addCell(labelSex_i);
                ws.addCell(labelNum_i);
            }

            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            wwb.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     **/


}
