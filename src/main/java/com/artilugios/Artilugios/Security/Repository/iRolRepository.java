
package com.artilugios.Artilugios.Security.Repository;



import com.artilugios.Artilugios.Security.Entity.Rol;
import com.portfolio.sh.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
