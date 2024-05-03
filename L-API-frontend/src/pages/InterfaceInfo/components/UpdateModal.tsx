import { ProTable, type ProColumns } from '@ant-design/pro-components';
import '@umijs/max';
import { Modal } from 'antd';
import {ProFormInstance} from "@ant-design/pro-form/lib";
import {useEffect, useRef} from "react";

export type Props = {
  columns: ProColumns<API.RuleListItem>[];
  onCancel: () => void;
  onSubmit: (values: API.InterfaceInfo) => Promise<void>;
  open: boolean;
  values:API.InterfaceInfo[];
};
const UpdateModal: React.FC<Props> = (props) => {
  const { values,open, columns, onCancel, onSubmit } = props;
  const formRef= useRef<ProFormInstance>();
  useEffect(()=>{
    if(formRef){
      formRef.current?.setFieldsValue(values);
    }
  },[values]);
  return (
    <Modal open={open} onCancel={() => onCancel?.()}>
      <ProTable
        type="form"
        formRef={formRef}
        columns={columns}
        onSubmit={async (value) => {
          onSubmit?.(value);
        }}
      />
    </Modal>
  );
};
export default UpdateModal;
