package component.export;

import java.util.Collection;

/**
 * 导出者该具备的素质
 * @author maihx
 *
 */
public interface Exportor {

	 /**
     * append数据
     * 
     * @param data
     */
    public void appendRecord(Collection<?> records) throws Exception;

    /**
     * 设置总记录数，为了获取到当前进度信息
     * 
     * @param total
     */
    public void setRecordTotal(int total);

    /**
     * 提供当前处理进度信息
     * 
     * @return
     */
    public int[] takeCurrentProgress();

    /**
     * 所有数据准备完毕的回调。 比如导出记录到Excel，所有数据已经写到excel文件里面的时候，这个方法会被调用
     */
    public void onDataReady();
}

