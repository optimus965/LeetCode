const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/pages/Home1.vue'),
  },
  {
    name: 'Login',
    path: '/account/login',
    component: () => import('@/pages/Login.vue'),
  },
  {
    name:'About',
    path:'/about',
    component:()=>import('@/aboutcomponent/AboutBt.vue')
  },
  {
    name:'ApplicationDevelopment',
    path:'/appdev',
    component:()=>import('@/itservices/ApplicationModernization.vue'),
  },
  {
    name:'CustomProduct',
    path:'/productdev',
    component:()=>import('@/itservices/ProductDevelopment.vue')
  },
  {
    name:'AppWeb',
    path:'/appweb',
    component:()=>import('@/itservices/AppandWebsite.vue')
  },
  {
    name:'UXUI',
    path:'/uxui',
    component:()=>import('@/itservices/UxUi.vue')
  },
  {
    name:'Contacts',
    path:'/contact',
    component:()=>import('@/contactspage/ContactBt.vue')
  }
]
