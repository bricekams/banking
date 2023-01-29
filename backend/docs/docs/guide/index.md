---
next: "Endpoints | Documentation"

---

# Introduction 

At school, we were given projects to carry out, mine was to create
a service for managing bank 
accounts in java. So I made some search about java development 
tools and came across Spring Boot; Then, i decided to create a Rest API for the backend of my bank account management system.
(The [frontend](https://github.com/jotterkain/finance/tree/main/mobile) is a mobile app made with Flutter, but that's not the point).

This API has been designed to facilitate the learning of
frontend developers who would like to 
improve their knowledge of Rest APIs. Thus, they 
will be able to create beautiful applications for banks and financial services without having to use real
(like real) APIs.

Those following tools are the main used to create this API:
- Spring Boot 3
- Docker 
- Postgres 15.1
- Intellij IDEA
<br/>
<br/>
<br/>
<br/>


<script setup>
import { VPTeamMembers } from 'vitepress/theme';

const members = [
  {
    avatar: 'https://avatars.githubusercontent.com/u/120424696?s=400&u=4b3e3aecdbad5a358576b22d903e2dc75174bd98&v=4',
    name: 'Jotter Kain',
    title: 'Main maintainer',
    links: [
      { icon: 'github', link: 'https://github.com/jotterkain' },
      { icon: 'twitter', link: 'https://twitter.com/jotterkain' }
    ]
  }
]

</script>

# Contributors

Thanks to the following people for their 
contributions to this open source project.

<VPTeamMembers size="small" :members="members" />