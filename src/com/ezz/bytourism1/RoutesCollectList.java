package com.ezz.bytourism1;

/**
 * Created by 37492 on 2016/4/7.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
public class RoutesCollectList extends Activity implements OnItemClickListener,OnScrollListener{
    private ListView listView;
    private ArrayAdapter< String> arr_adapter;
    private SimpleAdapter simp_adapter;
    private List<Map<String, Object>> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO �Զ����ɵķ������
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routescollect);
        listView = (ListView)findViewById(R.id.routeslist);
        //1.����һ������������
        //ArrayAdapter(�����ģ���ǰListView����ÿһ���б�������Ӧ�Ĳ����ļ�������Դ)
        //2.��������������Դ
        //3.��ͼ��ListView������������
		/*SimpleAdapter
		 * 1.����һ��������
		 * 2.��������������Դ
		 * 3.��ͼ(ListView)����������
		 * listView.setAapter(arr_adapter)
		 * */
        String[] arr_data = {"Ľ����1","Ľ����2","Ľ����3","Ľ����4","Ľ����5"};
        dataList = new ArrayList<Map<String,Object>>();
        arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr_data);
        //	listView.setAdapter(arr_adapter);

        /**
         * SimpleAdapter:
         * context��������
         * data������Դ(List< ?extends Map<String,?>>data)һ��Map����ɵ�List����
         * 			  ÿһ��Map����ȥ��ӦListView�б��һ��
         * 			 ÿһ��Map<��-ֵ��>�еļ������������from��ָ���ļ�
         * resource���б���Ĳ����ļ�ID
         * from��Map�еļ���
         * to��������Դ��ͼ��ID����from�ɶ�Ӧ��ϵ
         * */
        simp_adapter = new SimpleAdapter(this, getData(), R.layout.routescollect_item,new String[]{"pic","text"} ,new int[]{R.id.image,R.id.title});

        listView.setAdapter(simp_adapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
    }
    private List<Map<String, Object>> getData(){
        for(int i = 0;i<20;i++){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("pic", R.drawable.ic_launcher);
            map.put("text", "Ľ����"+i);
            dataList.add(map);

        }
        return dataList;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO �Զ����ɵķ������
        String text = listView.getItemAtPosition(position)+"";
        Toast.makeText(this, "position="+position +"text = "+text, Toast.LENGTH_LONG).show();

    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // TODO �Զ����ɵķ������
        switch (scrollState) {
            case SCROLL_STATE_FLING:
                Map<String, Object> map = new HashMap<String,Object>();
                map.put("pic", R.drawable.ic_launcher);
                map.put("text", "������");
                dataList.add(map);
                simp_adapter.notifyDataSetChanged();
                break;
            case SCROLL_STATE_IDLE:
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                break;
            default:
                break;
        }
    }
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        // TODO �Զ����ɵķ������

    }
}
