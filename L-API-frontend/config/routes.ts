export default [
  {
    path: '/user',
    layout: false,
    routes: [{ name: '登录', path: '/user/login', component: './User/Login' }],
  },
  // { path: '/welcome', name: '欢迎', icon: 'smile', component: './Welcome' },
  {
    path: '/admin',
    name: '管理页',
    icon: 'crown',
    access: 'canAdmin',
    routes: [
      { name: '接口信息', icon: 'table', path: '/admin/interface_info', component: './InterfaceInfo' },
    ],
  },
  // { name: '接口信息', icon: 'table', path: '/list', component: './InterfaceInfo' },
  // { path: '/', redirect: '/welcome' },
  { path: '*', layout: false, component: './404' },
];
