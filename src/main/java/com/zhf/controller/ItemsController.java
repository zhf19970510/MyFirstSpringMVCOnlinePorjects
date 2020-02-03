package com.zhf.controller;

import com.zhf.exception.CustomException;
import com.zhf.pojo.ItemsCustom;
import com.zhf.pojo.ItemsQueryVo;
import com.zhf.service.ItemsService;
import com.zhf.validation.ValidationGroup1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created on 2020/1/19 0019.
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/itemsManager")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    //自定义属性编辑器
//    @InitBinder
//    public void initBinder(WebDataBinder binder)throws Exception{
//        // POJO类日期类型属性createTime
//        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
//    }

    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception {
        System.out.println("进入了controller");
        List<ItemsCustom> itemsList = itemsService.findItemsList(null);
        System.out.println("可以到service");
        ModelAndView modelAndView = new ModelAndView("itemsList");
        modelAndView.addObject("items", itemsList);
        System.out.println("可以建modelAndView");
//        modelAndView.setViewName("forward:itemsList");
        System.out.println("视图名是：" + modelAndView.getViewName());
        return modelAndView;
    }

    @RequestMapping("/editItemsList")
    public ModelAndView editItemsList() throws Exception {

        System.out.println("进入了controller");
        List<ItemsCustom> itemsList = itemsService.findItemsList(null);
        System.out.println("可以到service");
        ModelAndView modelAndView = new ModelAndView("editItemsList");
        modelAndView.addObject("items", itemsList);
        System.out.println("可以建modelAndView");
//        modelAndView.setViewName("forward:itemsList");
        System.out.println("视图名是：" + modelAndView.getViewName());
        return modelAndView;
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("dsdadsa");
        return "itemsList";
    }

    @RequestMapping("editItems")
    public ModelAndView editItems(HttpServletRequest request) throws Exception {
        //通过id查询商品
        String id = request.getParameter("id");
        if(id==null || Integer.parseInt(id)<0){
            throw new CustomException("id 无效");
        }
        ItemsCustom itemsCustom = itemsService.findItemsById(Integer.parseInt(id));
        System.out.println("图片名称为："+itemsCustom.getPic());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("item", itemsCustom);
        modelAndView.setViewName("editItems");
        return modelAndView;
    }

    //根据商品id查看商品信息 rest接口返回json
    //@RequestMapping中指定URL的参数，{}包起来的参数和形参做绑定
    @RequestMapping("/viewItems/{id}")
    public @ResponseBody
    ItemsCustom viewItems(@PathVariable("id") Integer id)throws Exception{
        ItemsCustom itemsCustom = itemsService.findItemsById(id);
        return itemsCustom;
    }



    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(Model model, Integer id, /*@Validated(value = {ValidationGroup1.class})*/ ItemsCustom items, /*BindingResult bindingResult,*/ @RequestParam("picFile") MultipartFile[] files, HttpServletRequest request) throws Exception {

        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                // 保存文件
                String targetFileName = saveFile(request, file);
                items.setPic(targetFileName);
            }
        }
//        if(bindingResult.hasErrors()){
//            List<ObjectError>errors = bindingResult.getAllErrors();
//            model.addAttribute("errors",errors);
//            for (ObjectError error:errors){
//                System.out.println(error.getDefaultMessage());
//            }
//        }
        itemsService.updateItems(id,items);

        System.out.println(items);
        return "redirect:queryItems";

    }

    private String saveFile(HttpServletRequest request, MultipartFile file) {
        // 判断文件是否为空
        String targetFileName = "";
        if (!file.isEmpty() && file.getOriginalFilename()!=null && file.getOriginalFilename().length()>0) {
            try {
                //保存的文件路径
                String filePath = request.getServletContext().getRealPath("/");
                //上传的原始文件名
                String oldFileName = file.getOriginalFilename();
                //新文件名
                String newFileName = UUID.randomUUID()+oldFileName.substring(oldFileName.lastIndexOf("."));
                targetFileName = newFileName;
                //新文件
                File newFile = new File(filePath+"images/"+newFileName);
                //文件所在目录不存在就创建
                if (!newFile.getParentFile().exists()){
                    newFile.getParentFile().mkdirs();
                }

                // 转存文件
                file.transferTo(newFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return targetFileName;

    }

    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[]delete_id)throws Exception{
        return "success";
    }

    @RequestMapping("/updateItemsList")
    public String updateItemsList(ItemsQueryVo itemsQueryVo)throws Exception{
        System.out.println("有"+itemsQueryVo.getItemsList().size()+"个元素");
        return "success";
    }
}
