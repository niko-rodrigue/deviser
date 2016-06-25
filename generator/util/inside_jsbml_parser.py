import os


# command = 'javap -p org.sbml.jsbml.CompartmentalizedSBase'

def print_output(output):
    for line in output:
        print(line)

def clean_line(data):
    temp = []
    for i in data:
        if i !='':
            temp.append(i)
    return temp

def extract_data(temp_data):
    print(temp_data)
    # function_name_step1  = temp_data[-1].split(');')
    # print(function_name_step1)

    function_name = ''
    access_member = None
    is_abstract = False
    return_type = []
    arguments = []
    of_type = []

    for i in range(len(temp_data)):

        # Function Arguments extracter
        if '(' in temp_data[i]:
            print('i is ',i)
            function_name_step1  = temp_data[i].split('(')
            print('function_name_step1 ',function_name_step1)
            function_name = function_name_step1[0]
            function_index = i
            if function_name_step1[-1] != ');':
                if ');' in function_name_step1[-1]:
                    arg = function_name_step1[-1].split(');')[0]
                    arguments.append(arg)
                else:
                    arg = function_name_step1[-1].split(',')[0]
                    arguments.append(arg)
                    for y in range(function_index, len(temp_data)):
                        #print('y ',temp_data[y])
                        if ',' in temp_data[y]:
                            arg = function_name_step1[-1].split(',')[0]
                            arguments.append(arg)
                        elif ');' in function_name_step1[-1]:
                            arg = function_name_step1[-1].split(');')[0]
                            arguments.append(arg)
            elif function_name_step1[-1] == ');':
                break

            # else:
            #     arg = function_name_step1[-1].split(',')[0]
            #     arguments.append(arg)
            #     for y in range(len(temp_data[function_index+1:])):
            #         print('y is ',temp_data[y])
            print(function_name,'--', function_index) # THis works
            # function_name_step2  = function_name_step1[-1].split(');')
            # print(function_name_step2)
        elif '<' in temp_data[i]:
            pass

    print('function_name ',function_name)
    print('arguments ',arguments)
    print('-----------')
    # function_name = function_name_step2[0] 
    # print('function_name ',function_name)
    # print('------------------')           


def parse_output(output):
    output_data = {}
    for line in output:
        #print(line) 
        data_stage1 = line.split('\n')
        # print(data_stage1)       
        data_stage2 = data_stage1[0].split(' ')
        temp_data = clean_line(data_stage2)
        # print(line)
        # print(temp_data)
    
        extract_data(temp_data)
        
        # if '{' in temp_data:
        #     output_data.update({'classInfo':temp_data[:-1]})
        # elif function_name in temp_data:
        #     output_data.update({'methods':temp_data})
        # print('->'*20)
        # print('\n')
    return output_data

def get_class_information(class_name=None):
    command = 'javap -package {0}'.format(class_name)
    class_output  = os.popen('{0}'.format(command)).readlines()
    # print_output(class_output)
    dict_data = parse_output(class_output)
    print(dict_data)




# get_class_information()

# class_name = 'org.sbml.jsbml.CompartmentalizedSBase'

class_name = 'org.sbml.jsbml.AbstractNamedSBase'
get_class_information(class_name)