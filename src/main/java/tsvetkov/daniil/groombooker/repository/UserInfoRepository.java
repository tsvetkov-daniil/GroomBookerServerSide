package tsvetkov.daniil.groombooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tsvetkov.daniil.groombooker.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    @Query(value = "SELECT COUNT(*) > 0 FROM user_info WHERE first_name = :#{#userInfo.firstName} AND last_name = :#{#userInfo.lastName}", nativeQuery = true)
    boolean exists(@Param("userInfo") UserInfo userInfo);
    UserInfo getById(Integer userInfoId);
}
