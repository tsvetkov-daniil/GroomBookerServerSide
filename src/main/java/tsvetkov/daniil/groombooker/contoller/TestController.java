package tsvetkov.daniil.groombooker.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tsvetkov.daniil.groombooker.dto.AppUserDTO;
import tsvetkov.daniil.groombooker.dto.BranchDTO;
import tsvetkov.daniil.groombooker.dto.RoleDTO;
import tsvetkov.daniil.groombooker.entity.AppUser;
import tsvetkov.daniil.groombooker.entity.Branch;
import tsvetkov.daniil.groombooker.service.AppUserService;
import tsvetkov.daniil.groombooker.service.BranchService;
import tsvetkov.daniil.groombooker.service.RoleService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class TestController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private BranchService branchService;

    //-------------------------ROLES------------------------//
    @GetMapping("/roles")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @PostMapping("/roles")
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(roleService.save(roleDTO));
    }

    @PostMapping("/roles")
    public ResponseEntity<Set<RoleDTO>> createRole(@RequestBody Set<RoleDTO> roleDTO) {
        return ResponseEntity.ok(roleService.save(roleDTO));
    }

    //------------------------USERS---------------------------//
    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody AppUserDTO request)
    {
        System.out.println(request.toString());
        AppUser appUser = appUserService.createUser(request);
        return appUser == null? ResponseEntity.badRequest().build():ResponseEntity.ok(appUser.toString());
    }

    @PostMapping("/branch")
    public ResponseEntity<String> saveUser(@RequestBody BranchDTO request)
    {
        Branch branch = branchService.create(request);
        return branch == null? ResponseEntity.badRequest().build():ResponseEntity.ok("save");
    }
}
