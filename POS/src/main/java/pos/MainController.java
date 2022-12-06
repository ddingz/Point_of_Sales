package pos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@Autowired
	private MemberRegisterService memberRegisterService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private MemberDeleteService memberDeleteService;

	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ItemUpdateService itemUpdateService;
	@Autowired
	private ItemSellService itemSellService;

	@RequestMapping({ "/", "/login" })
	public String login(Model model) {
		model.addAttribute("loginRequest", new LoginRequest());
		
		return "login";
	}

	@RequestMapping("/insertMember")
	public String insertMember(Model model) {
		model.addAttribute("registerRequest", new RegisterRequest());
		
		return "insertMember";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/finishInsertMember")
	public String finishInsertMember(RegisterRequest regReq) {
		if (regReq.isPasswordEqualToConfirmPassword()) {
			try {
				memberRegisterService.regist(regReq);
				
				return "finishInsertMember";
			} catch (Exception ex) {
				return "insertMember";
			}
		} else {
			return "falseInsertMember";
		}
	}

	@RequestMapping("/deleteMember")
	public String deleteMember(Model model) {
		model.addAttribute("loginRequest", new LoginRequest());
		
		return "deleteMember";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/finishDeleteMember")
	public String finishDeleteMember(LoginRequest req) {
		try {
			if (!memberDeleteService.delete(req))
				return "falseDeleteMember";

			return "finishDeleteMember";
		} catch (Exception ex) {
			return "deleteMember";
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/finishLogin")
	public String finishLogin(LoginRequest req, Model model) {
		loginService.login(req);

		if (loginService.isSession())
			return "finishLogin";
		else
			return "login";
	}

	@RequestMapping("/pos")
	public String pos(Model model) {
		if (loginService.isSession()) {
			List<Item> itemList = itemDao.selectAll();
			model.addAttribute("items", itemList);
			
			return "pos";
		} else
			return "login";
	}

	@RequestMapping("/updateItem")
	public String updateItem(Model model) {
		List<Item> itemList = itemDao.selectAll();
		model.addAttribute("items", itemList);
		model.addAttribute("updateRequest", new UpdateRequest());
		
		return "updateItem";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/finishUpdateItem")
	public String finishUpdateItem(UpdateRequest req) {
		try {
			itemUpdateService.update(req);
			
			return "finishUpdateItem";
		} catch (Exception ex) {
			return "falseUpdateItem";
		}
	}

	@RequestMapping("/sellItem")
	public String sellItem(Model model) {
		List<Item> itemList = itemDao.selectAll();
		model.addAttribute("items", itemList);
		model.addAttribute("updateRequest", new UpdateRequest());
		
		return "sellItem";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/finishSellItem")
	public String finishSellItem(UpdateRequest req, Model model) {
		try {
			if (!itemSellService.sell(req))
				return "falseSellItem";

			int total;
			total = itemSellService.total(req);
			model.addAttribute("total", total);
			
			return "finishSellItem";
		} catch (Exception ex) {
			return "falseUpdateItem";
		}
	}

	@RequestMapping("soldList")
	public String soldList(Model model) {
		List<Item> itemList = itemDao.soldList();
		model.addAttribute("items", itemList);
		
		return "soldList";
	}

	@RequestMapping("logout")
	public String logout() {
		loginService.setSession(false);
		
		return "logout";
	}
}