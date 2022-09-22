package com.petfinder.backend.converters;
package com.petfinder.backend.entities.Role;
package com.petfinder.backend.data.RoleData;

public class RoleConverter extends Converter <Role, RoleData> {
    @override
    public Role toEntity(RoleData object){
        return Role.builder()
            .id(object.getId())
            .name(object.getName())
            .build()            
    }

    @override
    public RoleData toEntity(Role object){
        return RoleData.builder()
            .id(object.getId())
            .name(object.getName())
            .build()            
    }
}
